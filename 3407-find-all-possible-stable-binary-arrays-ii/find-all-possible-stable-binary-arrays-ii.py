class Solution:
    def numberOfStableArrays(self, zero, one, limit):
        MOD = 10**9 + 7

        dp0 = [[0]*(one+1) for _ in range(zero+1)]
        dp1 = [[0]*(one+1) for _ in range(zero+1)]

        for i in range(1, min(limit, zero) + 1):
            dp0[i][0] = 1

        for j in range(1, min(limit, one) + 1):
            dp1[0][j] = 1

        for i in range(1, zero+1):
            for j in range(1, one+1):

                val = (dp1[i-1][j] + dp0[i-1][j]) % MOD
                if i - limit - 1 >= 0:
                    val = (val - dp1[i-limit-1][j]) % MOD
                dp0[i][j] = val % MOD

                val = (dp0[i][j-1] + dp1[i][j-1]) % MOD
                if j - limit - 1 >= 0:
                    val = (val - dp0[i][j-limit-1]) % MOD
                dp1[i][j] = val % MOD

        return (dp0[zero][one] + dp1[zero][one]) % MOD