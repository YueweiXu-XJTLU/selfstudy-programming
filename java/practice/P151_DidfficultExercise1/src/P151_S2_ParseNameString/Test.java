package P151_S2_ParseNameString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        //task1
        String userStrs = "10001:张三:男:1990-01-01#" +
                "10002:李四:女:1989-01-09#" +
                "10003:王五:男:1999-09-09#" +
                "10004:刘备:男:1899-01-01#" +
                "10005:孙悟空:男:1900-01-01#" +
                "10006:张三:女:1999-01-01#" +
                "10007:刘备:女:1999-01-01#" +
                "10008:张三:女:2003-07-01#" +
                "10009:猪八戒:男:1900-01-01";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<User> user = new ArrayList<>();
        List<String> userStrArrays = new ArrayList<>();

        //String ---> String[]
        Collections.addAll(userStrArrays, userStrs.split("#"));

        //String[] ---> String
        for (String userStrArray : userStrArrays) {
            List<String> perUser = new ArrayList<>();
            userStrArray.split(":");
            Collections.addAll(perUser, userStrArray.split(":"));

            //parse and create new User
            Long id = Long.parseLong(perUser.get(0));
            String name = perUser.get(1);
            String gender = perUser.get(2);
            LocalDate birthday = LocalDate.parse(perUser.get(3), dtf);

            //add to List<User>
            User u = new User(id, name, gender, birthday);
            user.add(u);
        }



        //task2
        Map<String, Integer> nameStatistics = new HashMap<>();

        //Statistics
        for (User u : user) {
            if (nameStatistics.containsKey(u.getName())) {
                nameStatistics.put(u.getName(), nameStatistics.get(u.getName()) + 1);
            } else {
                nameStatistics.put(u.getName(), 1);
            }
        }

        //Print
        nameStatistics.forEach((k, v) -> System.out.println(k + ": " + v + "次"));
    }
}
