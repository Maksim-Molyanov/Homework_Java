import javax.management.StringValueExp;

//1) Дана строка sql-запроса "select * from students where ".
//        Сформируйте часть WHERE этого запроса, используя StringBuilder.
//        Данные для фильтрации приведены ниже в виде json строки.
//
//        Если значение null, то параметр не должен попадать в запрос.
//
//        Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class DZ2_task1 {

    public static void main(String[] args) {
        StringBuilder sql_request = new StringBuilder();
        sql_request.append("select * from students where ");
        String JSON = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        sql_request.append(makeWhereFromJSON(JSON));
        sql_request.append(";");
        System.out.println(sql_request);
    }

    public static StringBuilder makeWhereFromJSON(String JSON) {
        StringBuilder result = new StringBuilder();
        JSON = JSON.substring(1, JSON.length() - 1);

        boolean isFirstAnd = true;
        for (String params : JSON.split(",")) {
            String[] sub = params.split(":");
            String key = sub[0].replaceAll("\"", "");
            String value = sub[1];

            if (value.compareTo("\"null\"") == 0) {
                continue;
            }
            if (!isFirstAnd) {
                result.append(" and ");
            }

            isFirstAnd = false;
            result.append((key + "=" + value).trim());
        }
        return result;
    }
}
