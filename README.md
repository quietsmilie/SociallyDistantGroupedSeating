# SociallyDistantGroupedSeating

Expects:
    a list of groups to be seated with Size 
    a list of rows of seating with Size, distance from front (to fill front first)
  Both of these also provide a Hashtable to store any information relevant to the consumer
  
Returns:
  Rows and Seating Groups with links to indicate which groups are seated in which rows.  Seating Groups also have specific seat numbers assigned (starting with 1 in each row)
  
Logic:
  Starts with the first Seating Group provided, allowing for first come, first seated logic
  After initial seating, if there are unseated groups, runs optimization to seat as many as possible by re-arranging the seating
  Uses a specified number of "Social Distance Seats" between each group in a row
  Assumes only rows to be used are provided (see SociallyDistantGroupedSeatingWrapper for example of how to specify specific rows for specific events)
