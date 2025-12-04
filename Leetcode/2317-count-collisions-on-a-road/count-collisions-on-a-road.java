class Solution {
public int countCollisions(String directions) {
        char[] s = directions.toCharArray();
        int n = s.length;
        int ans = 0;
        for(int i = 0;i < n;i++){
            if(s[i] == 'S'){
                for(int j = i-1;j >= 0;j--){
                    if(s[j] == 'R'){
                        ans++;
                    }else{
                        break;
                    }
                }
                for(int j = i+1;j < n;j++){
                    if(s[j] == 'L'){
                        ans++;
                    }else{
                        break;
                    }
                }
            }
        }
        for(int i = 0;i < n-1;i++){
            if(s[i] == 'R' && s[i+1] == 'L'){
                ans += 2;
                for(int j = i-1;j >= 0;j--){
                    if(s[j] == 'R'){
                        ans++;
                    }else{
                        break;
                    }
                }
                for(int j = i+2;j < n;j++){
                    if(s[j] == 'L'){
                        ans++;
                    }else{
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}