package ru.vsu.cs.timetable.Helpers;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//GraphQLAPIParser - helps for transform data to graphql query
public class GraphQLAPIParser {

    private GraphQLAPIParser() {}

    public static boolean containsKey(Object object, List<String> keys) {
        boolean isContains = false;
        int counter = 0;

        for(String key : keys) {
            if (object.toString().contains(key)) {
                counter++;
            }
            if(counter == keys.size()) {
                isContains = true;
                break;
            }

        }
        return isContains;
    }

    public static boolean containsKey(List<LinkedHashMap<String, Object>> objectList, List<String> keyList) {
        boolean isContains = false;
        int counter = 0;

        for(LinkedHashMap<String, Object> hashMapElement : objectList) {
            for(String key : keyList) {
                if(hashMapElement.containsKey(key)) {
                    counter++;
                };
            }
            if(counter == keyList.size())
                isContains = true;
                break;
        }

        return isContains;
    }

    public static String parseMutationData(Map<String, Object> map) {
        String result = map
                .entrySet()
                .stream()
                .map(element -> element.getKey() + ": " + element.getValue())
                .collect(Collectors.joining(", "));

        return result;
    }

    public static String parseQueryKeys(List<String> keys) {
        String result = keys
                .stream()
                .collect(Collectors.joining(", "));

        return result;
    }

    public static String mutationTest(String mutationName, String inputType ,Map<String, Object> mockingData, List<String> returnedKeys) {
        String request  = "{\"query\":\"\\nmutation " + mutationName + "{\\n " + mutationName + "(" + inputType + ": {\\n " + parseMutationData(mockingData) + " \\n  }) {\\n "+ parseQueryKeys(returnedKeys) +" \\n  }\\n}\",\"variables\":{}}";

        return request;
    }

    public static String mutationDeleteTest(String mutationName, String param, Object paramValue, List<String> keys) {
        String request  = "{\"query\":\"\\nmutation " + mutationName +"  {\\n  " + mutationName + "(" + param + ":" + paramValue + ") {\\n  "+ parseQueryKeys(keys) +"   \\n    }\\n}\",\"variables\":{}}";

        return request;
    }

    public static String queryTest(String queryName, List<String> keys) {
        String request = "{\"query\":\"\\nquery " + queryName + " {\\n  " + queryName + " {\\n " + parseQueryKeys(keys) + "\\n    }\\n}\",\"variables\":{}}";

        return request;
    }

    public static String queryTest(String queryName, String param, Object paramValue, List<String> keys) {
        String request = "{\"query\":\"\\nquery " + queryName + " {\\n  " + queryName + "(" + param + ":" + paramValue + ")" + " {\\n " + parseQueryKeys(keys) + "\\n    }\\n}\",\"variables\":{}}";

        return request;
    }

}
