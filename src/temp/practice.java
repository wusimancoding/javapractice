package temp;

public class practice {
    public static void mergesort(int l,int r,int [] nums,int [] temp){
        if(l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergesort(l,mid,nums,temp);
        mergesort(mid + 1,r,nums,temp);
        int k = 0,i = l,j = mid + 1;
        while(i <= mid && j <= r) {
            if(nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while(i <= mid) {
            temp[k++] = nums[i++];
        }
        while(j <= r) {
            temp[k++] = nums[j++];
        }
        for(int x = 0,y = l; y <= r;x++,y++) {
            nums[y] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int [] {2,2,1,1,1,2,2};
        int[] temp = new int [ nums.length];
        mergesort(0,nums.length - 1,nums,temp);
        for(int x:nums) {
            System.out.println(x);
        }
        System.out.println("真的吗");
    }
}