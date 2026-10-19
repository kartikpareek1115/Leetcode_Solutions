import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {

        // Brute Force Approach -- TLE (Time Limit Exceeded)
        int modulo = 1_000_000_007;
        long sum = 0;
        int n = arr.length;

        /*
        for (int i = 0; i < n; i++) {
            int min = arr[i];

            for (int j = i; j < n; j++) {

                // Update the minimum for the current subarray
                min = Math.min(min, arr[j]);

                // Add the minimum of this subarray to sum
                sum = (sum + min) % modulo;
            }
        }

        return (int) sum;
        */

        // Optimized Approach: Monotonic Stack
        Stack<Integer> st = new Stack<>();

        // i visits every index, including n.
        // i == n acts as a virtual boundary after the last element.
        // It allows us to process any elements still remaining in the stack.
        for (int i = 0; i <= n; i++) {

            /*
             * Pop while:
             * 1. i == n: we have reached the end of the array, OR
             * 2. The current value is <= the value at the stack's top index.
             *
             * When an index is popped, we calculate how many subarrays
             * have arr[mid] as their minimum.
             */
            while (!st.isEmpty() &&
                   (i == n || arr[st.peek()] >= arr[i])) {

                // mid is the index of the element we're calculating for.
                int mid = st.pop();

                // Find the previous smaller element's index.
                // If the stack is empty, no such element exists,
                // so use -1 as the left boundary.
                int left = st.isEmpty() ? -1 : st.peek();

                // i is the right boundary: the current element stopped
                // arr[mid] from extending farther to the right.
                // If i == n, the boundary is just past the array's end.
                int right = i;

                // Number of possible starting positions for subarrays
                // that include mid and stay within its left boundary.
                long leftCount = mid - left;

                // Number of possible ending positions for subarrays
                // that include mid and stay before its right boundary.
                long rightCount = right - mid;

                /*
                 * Every combination of a valid start and end gives
                 * one subarray whose minimum is arr[mid].
                 *
                 * Contribution = value * number of starts * number of ends
                 */
                sum = (sum + (long) arr[mid] * leftCount * rightCount)
                      % modulo;
            }

            // Push the current index only if it is a real array index.
            // Never access arr[n], because n is outside the array.
            if (i < n) {
                st.push(i);
            }
        }

        // Return the final sum of all subarray minimums.
        return (int) sum;
    }
}