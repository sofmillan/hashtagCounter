import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        List<String> tweets = new ArrayList<>();
        tweets.add("#Java and #Scala are the languages");
        tweets.add("#Scala is functional language");
        tweets.add("#Java is non functional language");
        tweets.add("#Java is oop language");
        tweets.add("#Java is the best language");
        tweets.add("IBM are building an integrated platform with work with #Java #Scala and #cognitive");

        Map<String, Long>  hashtagCountMap = filterHashtags(tweets);
        System.out.println(hashtagCountMap);
    }


    public static Map<String, Long> filterHashtags(List<String> tweets){
        List<String> keywords = new ArrayList<>();

        Pattern hashtagPattern = Pattern.compile("#(\\S+)");

        tweets.stream().forEach(tweet ->{
                    Matcher matcher = hashtagPattern.matcher(tweet);
                    while (matcher.find()) {
                        keywords.add(matcher.group());
                    }
                });

        Map<String, Long> hashtagCountMap = new HashMap<>();

        keywords.forEach(word -> hashtagCountMap.compute(word, (key, value) -> value == null ? 1L : value + 1L));

        return hashtagCountMap;


    }
}