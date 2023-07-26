import java.net.*;
import java.io.*;
import java.util.*;

public class Task_4 {

    public String URLreader() throws Exception {
        HashMap<String, Integer> hashMap = new HashMap<>();
        try {

            String val;
            URL URL = new URL("https://deepstatemap.live/#9/46.4643/31.8686");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(URL.openStream()));
            List<String> lst = new ArrayList<>();
            char[] ch;
            while ((val = br.readLine()) != null) {
                String temp = "";
                ch = val.toCharArray();
                for(int i = 0; i < ch.length; i++){
                    if(ch[i] == '<' && ch[i+1] != '/'){
                        int n = i;
                        while(ch[n]!=' ' && ch[n]!='>'){
                            temp += ch[n];
                            n++;
                        }
                    }                }
                //System.out.println(temp);
                for(int j = 0; j < temp.split("<").length; j++){
                    lst.add(temp.split("<")[j]);
                }
            }
            br.close();

            lst.removeAll((Arrays.asList("", null)));
            int num = 0;
            for(int i = 0; i < lst.size(); i++){
                if(hashMap.containsKey(lst.get(i))){
                    Integer t = hashMap.get(lst.get(i));
                    hashMap.replace(lst.get(i), t+1);
                }
                else {num = 1; hashMap.put(lst.get(i), num);}
            }

            hashMap.forEach((key, value) -> System.out.println(key + " " + value));
            Scanner in = new Scanner(System.in);
            String choice = "";
            boolean end = false;
            do{
                System.out.println("\n1) Сортувати за алфавітом\n2) За значеннями");
                choice = in.nextLine();
                switch (choice) {
                    case "1" -> {
                        hashMap = sortByKey(hashMap);
                        end = true;

                    }
                    case "2" -> {
                        hashMap = sortByValue(hashMap);
                        end = true;}
                }
            }while (!end);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return hashMap.toString();
    }

    public static HashMap<String, Integer> sortByKey(Map<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list
                = new LinkedList<Map.Entry<String, Integer> >(
                hm.entrySet());

        // Sort the list using lambda expression
        Collections.sort(
                list, (i1, i2) -> i1.getKey().compareTo(i2.getKey()));

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp
                = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }


    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}