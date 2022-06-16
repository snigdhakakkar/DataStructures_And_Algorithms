##Every valid email consists of a local name and a domain name, separated by the '@' sign. 
# Besides lowercase letters, the email may contain one or more '.' or '+'.
# For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
# If you add periods '.' between some characters in the local name part of an email address, 
# mail sent there will be forwarded to the same address without dots in the local name. 
# Note that this rule does not apply to domain names.
# 
# For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
# If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.
# 
# For example, "m.y+name@email.com" will be forwarded to "my@email.com".
# It is possible to use both of these rules at the same time.
# 
# Given an array of strings emails where we send one email to each emails[i], 
# return the number of different addresses that actually receive mails.

##Method 1: Linear search in emails and append to a hashset: time complexity: O(N.M), space complexity: O(N.M)
from typing import List


def numUniqueEmails(self, emails: List[str]) -> int:
        ##taking a hashSet to store all the unique emails
        uniqueEmails = set()
        
        #iterating over each character in email
        for email in emails:
            cleanMail = []
            
            #iterating over each character in the current email
            for currChar in email:
                #stop adding if the character is '+'
                if currChar == '+' or currChar == '@':
                    break
                    
                #add the characters if not '.'
                if currChar != '.':
                    cleanMail.append(currChar)
                    
            #compute domain name (substring from end to '@')
            domainName = []
            for currChar in reversed(email):
                domainName.append(currChar)
                if currChar == '@':
                    break
                    
            #reverse domain name and append to the local name
            domainName = ''.join(domainName[::-1])
            cleanMail = ''.join(cleanMail)
            uniqueEmails.add(cleanMail + domainName)
            
        return len(uniqueEmails)

