def main():
    garb = int(input())
    nums = list(map(int, input().split()))
    total = 0
    for i in range(len(nums) - 1, 0, -1):
        if nums[i - 1] > nums[i]:
            if nums[i] - 1 < 0:
                return 1
            total += nums[i - 1] - (nums[i] - 1)
            nums[i - 1] = nums[i] - 1
        elif nums[i - 1] < nums[i]:
            continue
        else:
            return 1
        #print(nums)
    #print(nums)
    return total

print(main())
