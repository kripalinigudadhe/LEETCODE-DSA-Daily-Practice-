class Solution(object):
    def longestBalanced(self, s):
        n = len(s)
        
        if n == 0:
            return 0
        
        max_length = 1   # FIXED: single character case
        
        # ---------- CASE 1: Single character ----------
        count = 1
        for i in range(1, n):
            if s[i] == s[i-1]:
                count += 1
            else:
                count = 1
            max_length = max(max_length, count)
        
        # ---------- CASE 2: Two characters ----------
        def solve_two(x, y):
            prefix = {0: -1}
            cx = cy = 0
            ans = 0
            
            for i in range(n):
                if s[i] == x:
                    cx += 1
                elif s[i] == y:
                    cy += 1
                else:
                    # reset if third character appears
                    prefix = {0: i}
                    cx = cy = 0
                    continue
                
                diff = cx - cy
                
                if diff in prefix:
                    ans = max(ans, i - prefix[diff])
                else:
                    prefix[diff] = i
            
            return ans
        
        max_length = max(max_length, solve_two('a','b'))
        max_length = max(max_length, solve_two('a','c'))
        max_length = max(max_length, solve_two('b','c'))
        
        # ---------- CASE 3: Three characters ----------
        prefix = {(0,0): -1}
        ca = cb = cc = 0
        
        for i in range(n):
            if s[i] == 'a':
                ca += 1
            elif s[i] == 'b':
                cb += 1
            else:
                cc += 1
            
            diff1 = ca - cb
            diff2 = ca - cc
            
            if (diff1, diff2) in prefix:
                max_length = max(max_length, i - prefix[(diff1, diff2)])
            else:
                prefix[(diff1, diff2)] = i
        
        return max_length