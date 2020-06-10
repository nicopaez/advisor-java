# How To


Here are some useful code snippets

````java
# consuming the weather api at http://api.openweathermap.org/data/2.5/onecall
OkHttpClient client = new OkHttpClient();
ObjectMapper mapper = new ObjectMapper();
Map<String,Object> data =  new HashMap<String, Object>();
String apiKey = System.getenv("API_KEY");
String url = ENDPOINT + "?lat=45&lon=36&APPID=" + apiKey; //"?lat=#{@lat}&lon=#{@lon}&APPID=#{@api_key};
Request request = new Request.Builder()
        .url(url)
        .get()
        .build();
Response response = client.newCall(request).execute();
ObjectReader reader = mapper.readerFor(Map.class);
Map<String, Map<String, Object>> result = reader.readValue(response.body().string());
String temperature = result.get("current").get("temp").toString();
return Double.parseDouble(temperature);

````

