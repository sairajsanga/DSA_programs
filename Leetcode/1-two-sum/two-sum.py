class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # for i in range(len(nums)):
        #     for j in range(i+1,len(nums)):
        #         if(nums[i]+nums[j]==target):
        #             return [i,j]
        # return [-1,-1]
        mp={}
        result=[]
        for i in range(len(nums)):
            mp[nums[i]]=i

        for i in range(len(nums)):
            if target-nums[i] in mp and mp[target-nums[i]]!=i:
                return [i,mp[target-nums[i]]]

        return [-1,-1] if result==[] else result

        