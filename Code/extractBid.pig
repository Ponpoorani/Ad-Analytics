A = LOAD 'training1st/bid' using PigStorage('\t') AS (Bid_ID, Timestamp, iPinyou_ID , UserAgent, IP, Region, City, Ad_Exchange, Domain, URL, Anonymous_URL_ID, Ad_slot_ID, Ad_slot_width, Ad_slot_height, Ad_slot_visibility, Ad_slot_format, Ad_slot_floor_price, Creative_ID, Bidding_price , Advertiser_ID , User_Tags);


G = FOREACH A generate Bid_ID, Region, Ad_slot_format, User_Tags; 



STORE G INTO './Output' USING PigStorage('\t');


