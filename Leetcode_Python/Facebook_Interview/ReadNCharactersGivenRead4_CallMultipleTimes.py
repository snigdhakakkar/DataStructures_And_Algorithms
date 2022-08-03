from typing import List


class Solution:
    def __init__(self):
        self.buf4 = [''] * 4
        self.curr_used = 0
        self.curr_read = 0
        self.EOF = False
        
    def read(self, buf: List[str], n: int) -> int:
        
        num_read = 0
        while num_read < n and not self.EOF:
            if self.curr_used == self.curr_read:
                self.curr_read = read4(self.buf4)
                self.curr_used = 0
                if self.curr_read == 0:
                    self.EOF = True   
            else:
                delta = min(self.curr_read - self.curr_used, n - num_read)
                buf[num_read: num_read + delta] = self.buf4[self.curr_used:
                                                       self.curr_used + delta]
                num_read += delta
                self.curr_used += delta

        return num_read