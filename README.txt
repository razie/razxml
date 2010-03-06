/**  ____    __    ____  ____  ____/___      ____  __  __  ____
 *  (  _ \  /__\  (_   )(_  _)( ___) __)    (  _ \(  )(  )(  _ \
 *   )   / /(__)\  / /_  _)(_  )__)\__ \     )___/ )(__)(  ) _ <
 *  (_)\_)(__)(__)(____)(____)(____)___/    (__)  (______)(____/
 *                      
 *  Copyright (c) Razvan Cojocaru, 2007+, Creative Commons Attribution 3.0
 */

What's this?
------------
Getting rid of the stupid warning from sun when using apache. Me XML utilities wrapping those calls, compiled into a jar file.

Why?
----
Well, the stupid warning covers actual errors. Also, although the XML libraries are fluffy 99% of the time one can make do with only 3 calls: xpe, xpl, xpa.


Details
-------
Use Xmldoc as much as possible to load and manipulate XML documents. Stick to the 3 calls using XPATH.

