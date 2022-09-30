from collections import defaultdict
import heapq
from typing import List


class Twitter:
    
    def __init__(self):
        self.timeStamp = 0 #to keep a tab on most recent tweets, we would decrement it by 1 each time
        self.tweetMap = defaultdict(list) #hashmap for userId -> list of timeStamp, tweetId
        self.followMap = defaultdict(set) #hashmap for userId -> set of followeeIds
        #we took defaultdict here because if we take normal dictionary 
        # then we have to initialize a list or a set each time
        

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweetMap[userId].append([self.timeStamp, tweetId]) #we save timeStamp and tweetId in the dict
        self.timeStamp -= 1 #decrement timeStamp 
        

    def getNewsFeed(self, userId: int) -> List[int]:
        res = [] #ordered tweets most recent ones
        minHeap = []
        
        self.followMap[userId].add(userId) #condition in the question is to add the user in his own follower list
        for followeeId in self.followMap[userId]:
            if followeeId in self.tweetMap: #check if a particular followee has posted something
                index = len(self.tweetMap[followeeId]) - 1 #get the index of the most recent tweet of a followee
                timeStamp, tweetId = self.tweetMap[followeeId][index] 
                minHeap.append([timeStamp, tweetId, followeeId, index - 1]) #saving previous index to fetch the previous tweet if needed
        heapq.heapify(minHeap)
        
        while minHeap and len(res) < 10:
            timeStamp, tweetId, followeeId, index = heapq.heappop(minHeap)
            res.append(tweetId)
            if index >= 0:
                timeStamp, tweetId = self.tweetMap[followeeId][index]
                heapq.heappush(minHeap, [timeStamp, tweetId, followeeId, index - 1])
        return res
            
            
        

    def follow(self, followerId: int, followeeId: int) -> None:
        self.followMap[followerId].add(followeeId)
        

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId in self.followMap[followerId]:
            self.followMap[followerId].remove(followeeId)
        


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)