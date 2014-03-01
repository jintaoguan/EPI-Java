###Problem 7.1
Write a function that takes L and F, and returns the merge of L and F. Your code should use O(1) additional storage - it should reuse the nodes from the lists provided as input.  The only field you can change in a node is next.

###Problem 7.2
Given a reference to the head of a singly linked list L, how would you determine wether L ends in a null or reaches a cycle of nodes? Write a function that returns null if there does not exist a cycle, and the reference to the start of the cycle if a cycle is present. (You do not know the length of the list in advance.)

###Problem 7.3
Write a function that takes a pointer to an arbitrary node in a sorted circular linked list, and returns the median of the linked list.

###Problem 7.4
Let h1 and h2 be the heads of lists L1 and L2, respectively. Assume that L1 and L2 are well-formed, that is each consists of a finite sequence of nodes. (In particular, neither list has a cucle.) How would you determine if there exists a node r reachable from both h1 and h2 by following the next fields? If such a node exists, find the node that appears earliest when traversing the lists. You are constrained to use no more than constant storage.

###Problem 7.5     ---------TODO----------

###Problem 7.6
Write a function that takes a singly linked list L, and reorders the elements of L so that the new list represents even-odd(L). Your function should use O(1) additional storage. The only field you can change in a node is next.

###Problem 7.7
Let v be a node in a singly linked list L. Node v is not the tail; delete it in O(1) time.

###Problem 7.8
Given a singly linked list L and a number k, write a function to remove the k-th last element fron L. Your algorithm cannot use more than a few words of storage, regardless of the length of the list. In particular, you cannot assume that it is possible to record the legnth of the list.

###Problem 7.9
Given a linear time non-recursive function that reverses a singly linked list. The function should use no more than constant storage beyond that needed for the list itself.

###Problem 7.10
Write a function that determines whether a sequence represented by a singly linked list L is a palindrome. Assume L can be changed and does not have to be restored it to its original state.