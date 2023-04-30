import java.net.URL;
        import java.net.HttpURLConnection;
        import java.util.Scanner;
        import org.json.simple.*;
        import org.json.simple.parser.JSONParser;

public class weatherreport {
    public static void main(String[] args) {
        try {
            System.out.println("\nWeather Report --- Temperature Finder ----- \n");

            Scanner s = new Scanner(System.in);
            String city, state, country;
            System.out.println("Enter city, state and country :");
            city = s.next();
            state = s.next();
            country = s.next();


            URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q=" + city + "," + state + "," + country + "&limit=1&appid=57078c1cdcea920bd7c30301116f3cc5");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int rc = con.getResponseCode();
            //  System.out.println(rc);

            if (rc != 200)
                System.out.println("Error in establishing the connection !!!");
            else {
                String data = "";
                Scanner sc = new Scanner(url.openStream());

                while (sc.hasNext()) {
                    data += sc.nextLine();
                }
                sc.close();
               //  System.out.println("original data is : \n " + data + "\n\n");
                JSONParser par = new JSONParser();
                JSONArray arr = (JSONArray) par.parse(data);
                //   JSONObject obj = (JSONObject) par.parse(data);
                JSONObject obj = (JSONObject) arr.get(0);
                // System.out.println(obj);
                double lat = (double) obj.get("lat");
                String la = Double.toString(lat);
                double lon = (double) obj.get("lon");
                String lo = Double.toString(lon);

                URL u = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+la+"&lon="+lo+"&appid=57078c1cdcea920bd7c30301116f3cc5");
                HttpURLConnection con1 = (HttpURLConnection) u.openConnection();
                con1.setRequestMethod("GET");
                con1.connect();

               // System.out.println("\nhi Entered here...\n");
                String data1 = "";
                Scanner sc1 = new Scanner(u.openStream());

                while (sc1.hasNext()) {
                    data1 += sc1.nextLine();
                }
                sc1.close();
              //  System.out.println("data2 is here " + data1);
                JSONParser par1 = new JSONParser();
                JSONObject obj1 = (JSONObject) par1.parse(data1);
               // System.out.println(obj1);
                JSONObject main = (JSONObject) obj1.get("main");
              //  System.out.println(main);
                double temp = (double) main.get("temp");
                temp = temp - 273.15;           // to celcius
                JSONObject wind = (JSONObject) obj1.get("wind");

                System.out.println("Weather Report of "+city+" is:\n");
                System.out.println("Temperature: " + temp);
                System.out.println("Pressure: " + main.get("pressure"));
                System.out.println("Humidity: " + main.get("humidity"));
                System.out.println("Wind Speed: " + wind.get("speed"));

            }
        }
        catch(Exception e){

        }
    }
}
