import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class DesignTwitter {
    public static void main(String[] args) {
        
    }
}

class Twitter {

    HashMap<Integer, Set<Integer>> userNFollowerMap;
    TreeMap<Integer, int[]> tweetMap;
    int timeStamp;
    public Twitter() {
        userNFollowerMap = new HashMap<>();
        tweetMap = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        int[] userTweet = {userId, tweetId};
        tweetMap.put(timeStamp, userTweet);
        if (!userNFollowerMap.containsKey(userId)) {
            userNFollowerMap.put(userId, new HashSet<>());
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        for (int timeStamp : tweetMap.keySet()) {
            int[] userTweet = tweetMap.get(timeStamp);
            Set<Integer> followeeSet = userNFollowerMap.get(userId);
            if (userTweet[0] == userId || followeeSet.contains(userTweet[0])) {
                newsFeed.add(userTweet[1]);
            }
            if (newsFeed.size() >= 10) break;
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (userNFollowerMap.containsKey(followerId)) {
            userNFollowerMap.get(followerId).add(followeeId);
        } else{
            Set<Integer> followeeSet = new HashSet<>();
            followeeSet.add(followeeId);
            userNFollowerMap.put(followerId, followeeSet);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (userNFollowerMap.containsKey(followerId)) {
            if (userNFollowerMap.get(followerId).contains(followeeId)) {
                userNFollowerMap.get(followerId).remove(followeeId);
            }
        }
    }
}
