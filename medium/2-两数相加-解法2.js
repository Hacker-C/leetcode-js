/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
  let sum = 0
  let ret = new ListNode()
  let cur = ret
  while (l1 && l2) {
    sum = l1.val + l2.val + sum
    let base = sum % 10
    let node = new ListNode(base, null)
    cur.next = node
    cur = node
    if (sum >= 10) {
      sum = 1
    } else {
      sum = 0
    }
    l1 = l1.next
    l2 = l2.next
  }
  let temp = l1 || l2
  while (temp) {
    sum = temp.val + sum
    let base = sum % 10
    let node = new ListNode(base, null)
    cur.next = node
    cur = node
    if (sum >= 10) {
      sum = 1
    } else {
      sum = 0
    }
    temp = temp.next
  }
  if (sum > 0) {
    let node = new ListNode(1, null)
    cur.next = node
  }
  return ret.next
};