//O(n2) and O(1)
    public static void removeDuplicates(ListNode head){
        ListNode iter = head;
        while(iter!=null){
            int val = iter.val;
            ListNode prev = iter, temp = iter.next;
            while(temp!=null){
                if(temp.val==val){
                    prev.next = temp.next;
                    temp = temp.next;
                }
                else{
                    prev = prev.next;
                    temp = temp.next;
                }
            }
            iter = iter.next;
        }
    }
    
    //O(n) time and O(n) Space
    public void RemoveDuplicates(ListNode head){
		Set<Integer> set = new HashSet();
		ListNode iter = head; 
		ListNode dummy = new ListNode(0);
		ListNode ret = dummy;
		while(iter!=null){
			if(!set.contains(iter.val)){
				set.add(iter.val);
				dummy.next = iter;
				dummy = dummy.next;
			}
			iter = iter.next;
		}
		return ret.next;
	}


