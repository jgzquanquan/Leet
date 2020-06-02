import java.util.*;

/**
 * @author jgz
 * @Date 2020-04-13 09:16
 */
public class Twitter {

    private HashMap<Integer,Tweet> twitter;

    private HashMap<Integer, Set<Integer>> followings;

    private static int timestamp = 0;

    private PriorityQueue<Tweet> maxHeap;

    /** Initialize your data structure here. */
    public Twitter() {
        twitter = new HashMap<>();
        followings = new HashMap<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2.timestamp - o1.timestamp);
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if (twitter.containsKey(userId)){
            Tweet oldHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = oldHead;
            twitter.put(userId, newHead);
        }else {
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        maxHeap.clear();
        if (twitter.containsKey(userId)){
            maxHeap.offer(twitter.get(userId));
        }
        Set<Integer> follingList = followings.get(userId);
        if (follingList != null && follingList.size()>0){
            for (int id : follingList){
                Tweet tweet = twitter.get(id);
                if (tweet != null){
                    maxHeap.offer(tweet);
                }
            }
        }

        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while (!maxHeap.isEmpty() && count<10){
            Tweet head = maxHeap.poll();
            res.add(head.id);
            if (head.next!=null){
                maxHeap.offer(head.next);
            }
            count++;
        }
        return res;

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId){
            return;
        }
        Set<Integer> followingList = followings.get(followerId);
        if (followingList == null){
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followings.put(followerId,init);
        }else {
            if (followingList.contains(followeeId)) {
                return;
            }
            followingList.add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId){
            return;
        }

        Set<Integer> followingList = followings.get(followerId);
        if (followingList == null){
            return;
        }else {
            followingList.remove(followeeId);
        }
    }

    public static void main(String[] args) {

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        List<Integer> res1 = twitter.getNewsFeed(1);
        System.out.println(res1);

        twitter.follow(2, 1);

        List<Integer> res2 = twitter.getNewsFeed(2);
        System.out.println(res2);

        twitter.unfollow(2, 1);

        List<Integer> res3 = twitter.getNewsFeed(2);
        System.out.println(res3);
    }

}

class Tweet{
    int id;
    int timestamp;
    Tweet next;

    public Tweet(int id, int timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
}

