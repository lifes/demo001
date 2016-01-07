package com.xty.st.task;

import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenhuaming on 15/8/18.
 */
public class insertDoctorData {

    public static void main(String args[]) {
        FileInputStream fis = null;
        int i = 0;
        try {
            fis = new FileInputStream("总啊" +
                    ".csv");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;

            List<String> phoneNOs = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                i++;
                if (i < 2) continue;
                String[] strs = line.split(",");
                String name = strs[1];
                String username = strs[11];
                if ("".equals(username)) continue;
                int sex = Integer.parseInt("".equals(strs[2]) ? "0" : strs[2]);
                int user_role = Integer.parseInt(strs[6]);
                String icard_num = strs[3];
                String person_intro = strs[12];
                phoneNOs.add("\"" + username + "\"");

                JSONObject ext_info = new JSONObject();

                //user_info
                JSONObject userinfo = new JSONObject();
                userinfo.put("icard_num", icard_num);
                userinfo.put("person_intro", person_intro);
                ext_info.put("userinfo", userinfo);

                //doc info
                if (user_role != 2) {
                    JSONObject doctorinfo = new JSONObject();
                    String dqc_num = strs[9];
                    String ppc_num = strs[10];
                    String dpf_title = strs[8];
                    int hdepartment = Integer.parseInt("".equals(strs[4]) ? "2" : strs[4]);
                    doctorinfo.put("dqc_num", dqc_num);
                    doctorinfo.put("ppc_num", ppc_num);
                    doctorinfo.put("hdepartment", hdepartment);
                    doctorinfo.put("dpf_title", dpf_title);
                    ext_info.put("doctorinfo", doctorinfo);
                }
                 printfInsert(username, name, sex, user_role, 351, ext_info.toJSONString());
                 //printfUpadte(username, name, sex, user_role, 351, ext_info.toJSONString());
            }
            System.out.println(Arrays.toString(phoneNOs.toArray()));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);

            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void printfInsert(String username, String name, int sex, int user_role, int cityid, String ext_info) {
        String sql = "insert into xty_user_server (username, name, sex, user_role, cityid, ext_info, flag) values ('%s','%s',%d, %d, %d ,'%s',0);\n";
        System.out.printf(sql, username, name, sex, user_role, cityid, ext_info);
    }
    public static void printfUpadte(String username, String name, int sex, int user_role, int cityid, String ext_info){
        String sql = "update xty_user_server set name ='%s', sex = %d,  user_role = %d, cityid = %d,  ext_info = '%s', flag = 0 where username = '%s';\n";

        System.out.printf(sql, name, sex, user_role, cityid, ext_info, username);
    }
}