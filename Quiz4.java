private boolean inFirstHalf(Node P) {
  int position = 0;
  for(Node q = head; q != p && q != null; q = q.next) {
    position++;
  }
  
  int count = 0;
  for (Node q = head; q != null; q = q.next) {
      count++;
  }
  return 2 * position <= count;
}
