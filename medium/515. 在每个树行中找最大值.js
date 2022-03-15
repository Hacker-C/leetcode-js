/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues = function (root) {
  if (!root) return [];
  let q = [root], ans = [];
  while (q.length) {
    let len = q.length;
    let max = -Infinity;
    while (len--) {
      let node = q.shift();
      if (node.val > max) max = node.val;
      node.left && q.push(node.left);
      node.right && q.push(node.right);
    }
    ans.push(max);
  }
  return ans;
};