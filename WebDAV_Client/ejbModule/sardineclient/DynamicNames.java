/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sardineclient;

import com.github.sardine.DavResource;
import com.github.sardine.Sardine;
import com.test.webdav.FMFault_Exception;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class DynamicNames {

    boolean error = false; //Error parameter, if it equals true - something wrong

    public String getLink(Sardine sardine, String serverAddress) throws IOException, com.test.webdav.FMFault_Exception, ParserConfigurationException, SAXException {
        boolean asterisk_ex;
        //find 1st * - it is dynamic part in the name

        /**
         * Check if the address is dynamic
         */
        asterisk_ex = true;
        while (asterisk_ex) {
            if (serverAddress.indexOf("*") > 0) {
                //take stack with dynamic name - it could be a folder or a file
                int asterisk;
                String serverName_begin, serverName_end, serverName_dynamic;
                List<DavResource> resources;

                asterisk = serverAddress.indexOf("*");
                serverName_begin = serverAddress.substring(0, serverAddress.substring(0, asterisk).lastIndexOf("/")); //part of server name - before dynamic part
                serverName_end = serverAddress.substring(asterisk).substring(serverAddress.substring(asterisk).indexOf("/") + 1); //part of server name - end dynamic part
                serverName_dynamic = serverAddress.substring(serverName_begin.length(), serverAddress.length() - serverName_end.length()); //dynamic part

                //get all name in the directory serverName_begin
                resources = sardine.list(serverName_begin);
                serverName_dynamic = this.getCorrectName(resources, serverName_dynamic, serverName_begin);
                serverAddress = serverName_begin + serverName_dynamic + serverName_end;
            } else {
                asterisk_ex = false;
            }
        }
        return serverAddress;
    }

    /**
     * Check all names from folder and chouse correct one from the template
     *
     * @param resources
     * @param dynamicName
     * @return
     */
    private String getCorrectName(List<DavResource> resources, String dynamicName, String serverAddress) {
        String response, tempDynamicName;
        boolean answer;
        int minLength;
        ArrayList<DavResource> tempList;

        response = ""; //wrigth answer (if the program can't find address return "Error"
        answer = true; //answer not found yet, if found - answer = false

        //1st step - Check if the server doesn't contend any files/directories, if it's empty - return error
        if (resources.isEmpty()) {
            error = true;
            answer = false;
        }

        //2nd step - trying to find correct file or folder, if it doesn't exist return error
        tempDynamicName = dynamicName; //Temp for template
        minLength = 0; //How many symbols were used
        tempList = new ArrayList<DavResource>();
        Dictionary<DavResource, ArrayList<Double>> dictionary = new Hashtable<DavResource, ArrayList<Double>>();

        tempList.addAll(resources);
        while (answer) {//trying to find answer
            int asterisk;
            asterisk = tempDynamicName.indexOf("*");

            if (asterisk != -1) {
                minLength += asterisk;
                for (DavResource res : resources) {
                    if (!(res.toString().length() < minLength)) { //if name length less than template length
                        if (dictionary.get(res) == null) {
                            ArrayList<Double> num = new ArrayList<Double>();
                            num.add((double) res.toString().indexOf(tempDynamicName.substring(0, asterisk)));
                            dictionary.put(res, num);
                        } else {
                            ArrayList<Double> num = new ArrayList<Double>();
                            num = dictionary.get(res);
                            num.add((double) res.toString().indexOf(tempDynamicName.substring(0, asterisk)));
                            dictionary.put(res, num);
                        }
                    } else {
                        tempList.remove(res);
                    }
                }
            } else {
                for (DavResource res : resources) {
                    if (!(res.toString().length() < minLength)) { //if name length less than template length
                        ArrayList<Double> num = new ArrayList<Double>();
                        num = dictionary.get(res);
                        num.add((double) res.toString().indexOf(tempDynamicName));
                        dictionary.put(res, num);
                        answer = false;

                    } else {
                        tempList.remove(res);
                    }
                }
                //Check answers
                String correct_name;
                correct_name = "";

                for (DavResource each_res : resources) {
                    boolean correct_answer, answer_process;
                    correct_answer = true;
                    answer_process = true;

                    while (answer_process) {
                        double pr_num = -2;
                        if (dictionary.get(each_res) != null) {
                            for (Double number : dictionary.get(each_res)) {

                                if (!(pr_num == -2)) {
                                    if (number > pr_num) {
                                        correct_name = each_res.toString();
                                        pr_num = number;
                                    } else {
                                        correct_name = "";
                                        correct_answer = false;
                                        answer_process = false;
                                    }
                                } else {
                                    if (number >= 0) {
                                        correct_name = each_res.toString();
                                        pr_num = number;
                                    } else {
                                        correct_name = "";
                                        correct_answer = false;
                                        answer_process = false;
                                    }
                                }

                            }
                            answer_process = false;
                        } else {
                            correct_name = "";
                            correct_answer = false;
                            answer_process = false;
                        }
                    }

                    if (correct_answer) {
                        response = correct_name;
                    }

                }
            }
            tempDynamicName = tempDynamicName.substring(asterisk + 1);
        }
        return response;
    }
}
