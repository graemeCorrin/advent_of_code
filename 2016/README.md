<article class="day-desc"><h2>--- Day 1: No Time for a Taxicab ---</h2>
<p>Santa's sleigh uses a <span title="An atomic clock is too inaccurate; he might end up in a wall!">very high-precision clock</span> to guide its movements, and the clock's oscillator is regulated by stars. Unfortunately, the stars have been stolen... by the Easter Bunny.  To save Christmas, Santa needs you to retrieve all <em class="star">fifty stars</em> by December 25th.</p>
<p>Collect stars by solving puzzles.  Two puzzles will be made available on each day in the advent calendar; the second puzzle is unlocked when you complete the first.  Each puzzle grants <em class="star">one star</em>. Good luck!</p>
<p>You're airdropped near <em>Easter Bunny Headquarters</em> in a city somewhere.  "Near", unfortunately, is as close as you can get - the instructions on the Easter Bunny Recruiting Document the Elves intercepted start here, and nobody had time to work them out further.</p>
<p>The Document indicates that you should start at the given coordinates (where you just landed) and face North.  Then, follow the provided sequence: either turn left (<code>L</code>) or right (<code>R</code>) 90 degrees, then walk forward the given number of blocks, ending at a new intersection.</p>
<p>There's no time to follow such ridiculous instructions on foot, though, so you take a moment and work out the destination.  Given that you can only walk on the <a href="https://en.wikipedia.org/wiki/Taxicab_geometry">street grid of the city</a>, how far is the shortest path to the destination?</p>
<p>For example:</p>
<ul>
<li>Following <code>R2, L3</code> leaves you <code>2</code> blocks East and <code>3</code> blocks North, or <code>5</code> blocks away.</li>
<li><code>R2, R2, R2</code> leaves you <code>2</code> blocks due South of your starting position, which is <code>2</code> blocks away.</li>
<li><code>R5, L5, R5, R3</code> leaves you <code>12</code> blocks away.</li>
</ul>
<p><em>How many blocks away</em> is Easter Bunny HQ?</p>
</article>

<article class="day-desc"><h2>--- Part Two ---</h2><p>Then, you notice the instructions continue on the back of the Recruiting Document.  Easter Bunny HQ is actually at the first location you visit twice.</p>
<p>For example, if your instructions are <code>R8, R4, R4, R8</code>, the first location you visit twice is <code>4</code> blocks away, due East.</p>
<p>How many blocks away is the <em>first location you visit twice</em>?</p>
</article>



<article class="day-desc"><h2>--- Day 2: Bathroom Security ---</h2><p>You arrive at <em>Easter Bunny Headquarters</em> under cover of darkness. However, you left in such a rush that you forgot to use the bathroom! Fancy office buildings like this one usually have keypad locks on their bathrooms, so you search the front desk for the code.</p>
<p>"In order to improve security," the document you find says, "bathroom codes will no longer be written down.  Instead, please memorize and follow the procedure below to access the bathrooms."</p>
<p>The document goes on to explain that each button to be pressed can be found by starting on the previous button and moving to adjacent buttons on the keypad: <code>U</code> moves up, <code>D</code> moves down, <code>L</code> moves left, and <code>R</code> moves right. Each line of instructions corresponds to one button, starting at the previous button (or, for the first line, <em>the "5" button</em>); press whatever button you're on at the end of each line. If a move doesn't lead to a button, ignore it.</p>
<p>You can't hold it much longer, so you decide to figure out the code as you walk to the bathroom. You picture a keypad like this:</p>
<pre><code>1 2 3
4 5 6
7 8 9
</code></pre>
<p>Suppose your instructions are:</p>
<pre><code>ULL
RRDDD
LURDL
UUUUD
</code></pre>
<ul>
<li>You start at "5" and move up (to "2"), left (to "1"), and left (you can't, and stay on "1"), so the first button is <code>1</code>.</li>
<li>Starting from the previous button ("1"), you move right twice (to "3") and then down three times (stopping at "9" after two moves and ignoring the third), ending up with <code>9</code>.</li>
<li>Continuing from "9", you move left, up, right, down, and left, ending with <code>8</code>.</li>
<li>Finally, you move up four times (stopping at "2"), then down once, ending with <code>5</code>.</li>
</ul>
<p>So, in this example, the bathroom code is <code>1985</code>.</p>
<p>Your puzzle input is the instructions from the document you found at the front desk. What is the <em>bathroom code</em>?</p>
</article>

<article class="day-desc"><h2>--- Part Two ---</h2><p>You finally arrive at the bathroom (it's a several minute walk from the lobby so visitors can behold the many fancy conference rooms and water coolers on this floor) and go to punch in the code.  Much to your bladder's dismay, the keypad is not at all like you imagined it.  Instead, you are confronted with the result of hundreds of man-hours of <span title="User Group 143 found a diamond shape to be the most environmentally friendly.">bathroom-keypad-design meetings</title>:</p>
<pre><code>    1
  2 3 4
5 6 7 8 9
  A B C
    D
</code></pre>
<p>You still start at "5" and stop when you're at an edge, but given the same instructions as above, the outcome is very different:</p>
<ul>
<li>You start at "5" and don't move at all (up and left are both edges), ending at <code>5</code>.</li>
<li>Continuing from "5", you move right twice and down three times (through "6", "7", "B", "D", "D"), ending at <code>D</code>.</li>
<li>Then, from "D", you move five more times (through "D", "B", "C", "C", "B"), ending at <code>B</code>.</li>
<li>Finally, after five more moves, you end at <code>3</code>.</li>
</ul>
<p>So, given the actual keypad layout, the code would be <code>5DB3</code>.</p>
<p>Using the same instructions in your puzzle input, what is the correct <em>bathroom code</em>?</p>
</article>



<article class="day-desc"><h2>--- Day 3: Squares With Three Sides ---</h2><p>Now that you can think clearly, you move deeper into the labyrinth of hallways and office furniture that makes up this part of Easter Bunny HQ. This must be a graphic design department; the walls are covered in specifications for triangles.</p>
<p>Or are they?</p>
<p>The design document gives the side lengths of each triangle it describes, but... <code>5 10 25</code>?  Some of these aren't triangles. You can't help but mark the impossible ones.</p>
<p>In a valid triangle, the sum of any two sides must be larger than the remaining side.  For example, the "triangle" given above is <span title="Unless it's on a sphere!">impossible</span>, because <code>5 + 10</code> is not larger than <code>25</code>.</p>
<p>In your puzzle input, <em>how many</em> of the listed triangles are <em>possible</em>?</p>
</article>

<article class="day-desc"><h2>--- Part Two ---</h2><p>Now that you've helpfully marked up their design documents, it occurs to you that triangles are specified in groups of three <em>vertically</em>.  Each set of three numbers in a column specifies a triangle.  Rows are unrelated.</p>
<p>For example, given the following specification, numbers with the same hundreds digit would be part of the same triangle:</p>
<pre><code>101 301 501
102 302 502
103 303 503
201 401 601
202 402 602
203 403 603
</code></pre>
<p>In your puzzle input, and instead reading by columns, <em>how many</em> of the listed triangles are <em>possible</em>?</p>
</article>




<article class="day-desc"><h2>--- Day 4: Security Through Obscurity ---</h2><p>Finally, you come across an information kiosk with a list of rooms.  Of course, the list is encrypted and full of decoy data, but the instructions to decode the list are barely hidden nearby.  Better remove the decoy data first.</p>
<p>Each room consists of an encrypted name (lowercase letters separated by dashes) followed by a dash, a sector ID, and a checksum in square brackets.</p>
<p>A room is real (not a decoy) if the checksum is the five most common letters in the encrypted name, in order, with ties broken by alphabetization.  For example:</p>
<ul>
<li><code>aaaaa-bbb-z-y-x-123[abxyz]</code> is a real room because the most common letters are <code>a</code> (5), <code>b</code> (3), and then a tie between <code>x</code>, <code>y</code>, and <code>z</code>, which are listed alphabetically.</li>
<li><code>a-b-c-d-e-f-g-h-987[abcde]</code> is a real room because although the letters are all tied (1 of each), the first five are listed alphabetically.</li>
<li><code>not-a-real-room-404[oarel]</code> is a real room.</li>
<li><code>totally-real-room-200[decoy]</code> is not.</li>
</ul>
<p>Of the real rooms from the list above, the sum of their sector IDs is <code>1514</code>.</p>
<p>What is the <em>sum of the sector IDs of the real rooms</em>?</p>
</article>

<article class="day-desc"><h2>--- Part Two ---</h2><p>With all the decoy data out of the way, it's time to decrypt this list and get moving.</p>
<p>The room names are encrypted by a state-of-the-art <a href="https://en.wikipedia.org/wiki/Caesar_cipher">shift cipher</a>, which is nearly unbreakable without <span title="...or, like, half of a napkin.">the right software</span>. However, the information kiosk designers at Easter Bunny HQ were not expecting to deal with a master cryptographer like yourself.</p>
<p>To decrypt a room name, rotate each letter forward through the alphabet a number of times equal to the room's sector ID.  <code>A</code> becomes <code>B</code>, <code>B</code> becomes <code>C</code>, <code>Z</code> becomes <code>A</code>, and so on. Dashes become spaces.</p>
<p>For example, the real name for <code>qzmt-zixmtkozy-ivhz-343</code> is <code>very encrypted name</code>.</p>
<p><em>What is the sector ID</em> of the room where North Pole objects are stored?</p>
</article>



<article class="day-desc"><h2>--- Day 5: How About a Nice Game of Chess? ---</h2><p>You are faced with a security door designed by Easter Bunny engineers that seem to have acquired most of their security knowledge by watching <a href="https://en.wikipedia.org/wiki/Hackers_(film)">hacking</a> <a href="https://en.wikipedia.org/wiki/WarGames">movies</a>.</p>
<p>The <em>eight-character password</em> for the door is generated one character at a time by finding the <a href="https://en.wikipedia.org/wiki/MD5">MD5</a> hash of some Door ID (your puzzle input) and an increasing integer index (starting with <code>0</code>).</p>
<p>A hash indicates the <em>next character</em> in the password if its <a href="https://en.wikipedia.org/wiki/Hexadecimal">hexadecimal</a> representation starts with <em>five zeroes</em>. If it does, the sixth character in the hash is the next character of the password.</p>
<p>For example, if the Door ID is <code>abc</code>:</p>
<ul>
<li>The first index which produces a hash that starts with five zeroes is <code>3231929</code>, which we find by hashing <code>abc3231929</code>; the sixth character of the hash, and thus the first character of the password, is <code>1</code>.</li>
<li><code>5017308</code> produces the next interesting hash, which starts with <code>000008f82...</code>, so the second character of the password is <code>8</code>.</li>
<li>The third time a hash starts with five zeroes is for <code>abc5278568</code>, discovering the character <code>f</code>.</li>
</ul>
<p>In this example, after continuing this search a total of eight times, the password is <code>18f47a30</code>.</p>
<p>Given the actual Door ID, <em>what is the password</em>?</p>
</article>

<article class="day-desc"><h2>--- Part Two ---</h2><p>As the door slides open, you are presented with a second door that uses a slightly more <span title="This one says 'WOPR' in block letters.">inspired</span> security mechanism. Clearly unimpressed by the last version (in what movie is the password decrypted <em>in order</em>?!), the Easter Bunny engineers have worked out <a href="https://www.youtube.com/watch?v=NHWjlCaIrQo&t=25">a better solution</a>.</p>
<p>Instead of simply filling in the password from left to right, the hash now also indicates the <em>position</em> within the password to fill. You still look for hashes that begin with five zeroes; however, now, the <em>sixth</em> character represents the <em>position</em> (<code>0</code>-<code>7</code>), and the <em>seventh</em> character is the character to put in that position.</p>
<p>A hash result of <code>000001f</code> means that <code>f</code> is the <em>second</em> character in the password. Use only the <em>first result</em> for each position, and ignore invalid positions.</p>
<p>For example, if the Door ID is <code>abc</code>:</p>
<ul>
<li>The first interesting hash is from <code>abc3231929</code>, which produces <code>0000015...</code>; so, <code>5</code> goes in position <code>1</code>: <code>_5______</code>.</li>
<li>In the previous method, <code>5017308</code> produced an interesting hash; however, it is ignored, because it specifies an invalid position (<code>8</code>).</li>
<li>The second interesting hash is at index <code>5357525</code>, which produces <code>000004e...</code>; so, <code>e</code> goes in position <code>4</code>: <code>_5__e___</code>.</li>
</ul>
<p>You almost choke on your popcorn as the final character falls into place, producing the password <code>05ace8e3</code>.</p>
<p>Given the actual Door ID and this new method, <em>what is the password</em>? Be extra proud of your solution if it uses a cinematic "decrypting" animation.</p>
</article>



<article class="day-desc"><h2>--- Day 6: Signals and Noise ---</h2><p>Something is jamming your communications with Santa. Fortunately, your signal is only partially jammed, and protocol in situations like this is to switch to a simple <a href="https://en.wikipedia.org/wiki/Repetition_code">repetition code</a> to get the message through.</p>
<p>In this model, the same message is sent repeatedly.  You've recorded the repeating message signal (your puzzle input), but the data seems quite corrupted - almost too badly to recover. <em>Almost</em>.</p>
<p>All you need to do is figure out which character is most frequent for each position. For example, suppose you had recorded the following messages:</p>
<pre><code>eedadn
drvtee
eandsr
raavrd
atevrs
tsrnev
sdttsa
rasrtv
nssdts
ntnada
svetve
tesnvt
vntsnd
vrdear
dvrsen
enarar
</code></pre>
<p>The most common character in the first column is <code>e</code>; in the second, <code>a</code>; in the third, <code>s</code>, and so on. Combining these characters returns the error-corrected message, <code>easter</code>.</p>
<p>Given the recording in your puzzle input, <em>what is the error-corrected version</em> of the message being sent?</p>
</article>



<article class="day-desc"><h2>--- Day 7: Internet Protocol Version 7 ---</h2><p>While snooping around the local network of EBHQ, you compile a list of <a href="https://en.wikipedia.org/wiki/IP_address">IP addresses</a> (they're IPv7, of course; <a href="https://en.wikipedia.org/wiki/IPv6">IPv6</a> is much too limited). You'd like to figure out which IPs support <em>TLS</em> (transport-layer snooping).</p>
<p>An IP supports TLS if it has an Autonomous Bridge Bypass Annotation, or <span title="Any similarity to the pattern it describes is purely coincidental."><em>ABBA</em></span>.  An ABBA is any four-character sequence which consists of a pair of two different characters followed by the reverse of that pair, such as <code>xyyx</code> or <code>abba</code>.  However, the IP also must not have an ABBA within any hypernet sequences, which are contained by <em>square brackets</em>.</p>
<p>For example:</p>
<ul>
<li><code>abba[mnop]qrst</code> supports TLS (<code>abba</code> outside square brackets).</li>
<li><code>abcd[bddb]xyyx</code> does <em>not</em> support TLS (<code>bddb</code> is within square brackets, even though <code>xyyx</code> is outside square brackets).</li>
<li><code>aaaa[qwer]tyui</code> does <em>not</em> support TLS (<code>aaaa</code> is invalid; the interior characters must be different).</li>
<li><code>ioxxoj[asdfgh]zxcvbn</code> supports TLS (<code>oxxo</code> is outside square brackets, even though it's within a larger string).</li>
</ul>
<p><em>How many IPs</em> in your puzzle input support TLS?</p>
</article>



<article class="day-desc"><h2>--- Day 8: Two-Factor Authentication ---</h2><p>You come across a door implementing what you can only assume is an implementation of <a href="https://en.wikipedia.org/wiki/Multi-factor_authentication">two-factor authentication</a> after a long game of <a href="https://en.wikipedia.org/wiki/Requirement">requirements</a> <a href="https://en.wikipedia.org/wiki/Chinese_whispers">telephone</a>.</p>
<p>To get past the door, you first swipe a keycard (no problem; there was one on a nearby desk). Then, it displays a code on a <a href="https://www.google.com/search?q=tiny+lcd&tbm=isch">little screen</a>, and you type that code on a keypad. Then, presumably, the door unlocks.</p>
<p>Unfortunately, the screen has been <span title="BUT BY WHOM?!">smashed</span>. After a few minutes, you've taken everything apart and figured out how it works. Now you just have to work out what the screen <em>would</em> have displayed.</p>
<p>The magnetic strip on the card you swiped encodes a series of instructions for the screen; these instructions are your puzzle input. The screen is <em><code>50</code> pixels wide and <code>6</code> pixels tall</em>, all of which start <em>off</em>, and is capable of three somewhat peculiar operations:</p>
<ul>
<li><code>rect AxB</code> turns <em>on</em> all of the pixels in a rectangle at the top-left of the screen which is <code>A</code> wide and <code>B</code> tall.</li>
<li><code>rotate row y=A by B</code> shifts all of the pixels in row <code>A</code> (0 is the top row) <em>right</em> by <code>B</code> pixels. Pixels that would fall off the right end appear at the left end of the row.</li>
<li><code>rotate column x=A by B</code> shifts all of the pixels in column <code>A</code> (0 is the left column) <em>down</em> by <code>B</code> pixels. Pixels that would fall off the bottom appear at the top of the column.</li>
</ul>
<p>For example, here is a simple sequence on a smaller screen:</p>
<ul>
<li><p><code>rect 3x2</code> creates a small rectangle in the top-left corner:</p><pre><code>###....
###....
.......</code></pre></li>
<li><p><code>rotate column x=1 by 1</code> rotates the second column down by one pixel:</p><pre><code>#.#....
###....
.#.....</code></pre></li>
<li><p><code>rotate row y=0 by 4</code> rotates the top row right by four pixels:</p><pre><code>....#.#
###....
.#.....</code></pre></li>
<li><p><code>rotate column x=1 by 1</code> again rotates the second column down by one pixel, causing the bottom pixel to wrap back to the top:</p><pre><code>.#..#.#
#.#....
.#.....</code></pre></li>
</ul>
<p>As you can see, this display technology is extremely powerful, and will soon dominate the tiny-code-displaying-screen market.  That's what the advertisement on the back of the display tries to convince you, anyway.</p>
<p>There seems to be an intermediate check of the voltage used by the display: after you swipe your card, if the screen did work, <em>how many pixels should be lit?</em></p>
</article>



<article class="day-desc"><h2>--- Day 9: Explosives in Cyberspace ---</h2><p>Wandering around a secure area, you come across a datalink port to a new part of the network. After briefly scanning it for interesting files, you find one file in particular that catches your attention. It's compressed with an experimental format, but fortunately, the documentation for the format is nearby.</p>
<p>The format compresses a sequence of characters. Whitespace is ignored. To indicate that some sequence should be repeated, a marker is added to the file, like <code>(10x2)</code>. To decompress this marker, take the subsequent <code>10</code> characters and repeat them <code>2</code> times. Then, continue reading the file <em>after</em> the repeated data.  The marker itself is not included in the decompressed output.</p>
<p>If parentheses or other characters appear within the data referenced by a marker, that's okay - treat it like normal data, not a marker, and then resume looking for markers after the decompressed section.</p>
<p>For example:</p>
<ul>
<li><code>ADVENT</code> contains no markers and decompresses to itself with no changes, resulting in a decompressed length of <code>6</code>.</li>
<li><code>A(1x5)BC</code> repeats only the <code>B</code> a total of <code>5</code> times, becoming <code>ABBBBBC</code> for a decompressed length of <code>7</code>.</li>
<li><code>(3x3)XYZ</code> becomes <code>XYZXYZXYZ</code> for a decompressed length of <code>9</code>.</li>
<li><code>A(2x2)BCD(2x2)EFG</code> doubles the <code>BC</code> and <code>EF</code>, becoming <code>ABCBCDEFEFG</code> for a decompressed length of <code>11</code>.</li>
<li><code>(6x1)(1x3)A</code> simply becomes <code>(1x3)A</code> - the <code>(1x3)</code> looks like a marker, but because it's within a data section of another marker, it is not treated any differently from the <code>A</code> that comes after it. It has a decompressed length of <code>6</code>.</li>
<li><code>X(8x2)(3x3)ABCY</code> becomes <code>X(3x3)ABC(3x3)ABCY</code> (for a decompressed length of <code>18</code>), because the decompressed data from the <code>(8x2)</code> marker (the <code>(3x3)ABC</code>) is skipped and not processed further.</li>
</ul>
<p>What is the <em>decompressed length</em> of the file (your puzzle input)? Don't count whitespace.</p>
</article>



<article class="day-desc"><h2>--- Day 10: Balance Bots ---</h2><p>You come upon a factory in which many robots are <a href="https://www.youtube.com/watch?v=JnkMyfQ5YfY&t=40">zooming around</a> handing small microchips to each other.</p>
<p>Upon closer examination, you notice that each bot only proceeds when it has <em>two</em> microchips, and once it does, it gives each one to a different bot or puts it in a marked "output" bin. Sometimes, bots take microchips from "input" bins, too.</p>
<p>Inspecting one of the microchips, it seems like they each contain a single number; the bots must use some logic to decide what to do with each chip. You access the local control computer and download the bots' instructions (your puzzle input).</p>
<p>Some of the instructions specify that a specific-valued microchip should be given to a specific bot; the rest of the instructions indicate what a given bot should do with its <em>lower-value</em> or <em>higher-value</em> chip.</p>
<p>For example, consider the following instructions:</p>
<pre><code>value 5 goes to bot 2
bot 2 gives low to bot 1 and high to bot 0
value 3 goes to bot 1
bot 1 gives low to output 1 and high to bot 0
bot 0 gives low to output 2 and high to output 0
value 2 goes to bot 2
</code></pre>
<ul>
<li>Initially, bot <code>1</code> starts with a value-<code>3</code> chip, and bot <code>2</code> starts with a value-<code>2</code> chip and a value-<code>5</code> chip.</li>
<li>Because bot <code>2</code> has two microchips, it gives its lower one (<code>2</code>) to bot <code>1</code> and its higher one (<code>5</code>) to bot <code>0</code>.</li>
<li>Then, bot <code>1</code> has two microchips; it puts the value-<code>2</code> chip in output <code>1</code> and gives the value-<code>3</code> chip to bot <code>0</code>.</li>
<li>Finally, bot <code>0</code> has two microchips; it puts the <code>3</code> in output <code>2</code> and the <code>5</code> in output <code>0</code>.</li>
</ul>
<p>In the end, output bin <code>0</code> contains a value-<code>5</code> microchip, output bin <code>1</code> contains a value-<code>2</code> microchip, and output bin <code>2</code> contains a value-<code>3</code> microchip. In this configuration, bot number <em><code>2</code></em> is responsible for comparing value-<code>5</code> microchips with value-<code>2</code> microchips.</p>
<p>Based on your instructions, <em>what is the number of the bot</em> that is responsible for comparing value-<code>61</code> microchips with value-<code>17</code> microchips?</p>
</article>



<article class="day-desc"><h2>--- Day 11: Radioisotope Thermoelectric Generators ---</h2><p>You come upon a column of four floors that have been entirely sealed off from the rest of the building except for a small dedicated lobby.  There are some radiation warnings and a big sign which reads "Radioisotope Testing Facility".</p>
<p>According to the project status board, this facility is currently being used to experiment with <a href="https://en.wikipedia.org/wiki/Radioisotope_thermoelectric_generator">Radioisotope Thermoelectric Generators</a> (RTGs, or simply "generators") that are designed to be paired with specially-constructed microchips. Basically, an RTG is a highly radioactive rock that generates electricity through heat.</p>
<p>The <span title="The previous version, model number PB-NUK, used Blutonium.">experimental RTGs</span> have poor radiation containment, so they're dangerously radioactive. The chips are prototypes and don't have normal radiation shielding, but they do have the ability to <em>generate an electromagnetic radiation shield when powered</em>.  Unfortunately, they can <em>only</em> be powered by their corresponding RTG. An RTG powering a microchip is still dangerous to other microchips.</p>
<p>In other words, if a chip is ever left in the same area as another RTG, and it's not connected to its own RTG, the chip will be <em>fried</em>. Therefore, it is assumed that you will follow procedure and keep chips connected to their corresponding RTG when they're in the same room, and away from other RTGs otherwise.</p>
<p>These microchips sound very interesting and useful to your current activities, and you'd like to try to retrieve them.  The fourth floor of the facility has an assembling machine which can make a self-contained, shielded computer for you to take with you - that is, if you can bring it all of the RTGs and microchips.</p>
<p>Within the radiation-shielded part of the facility (in which it's safe to have these pre-assembly RTGs), there is an elevator that can move between the four floors. Its capacity rating means it can carry at most yourself and two RTGs or microchips in any combination. (They're rigged to some heavy diagnostic equipment - the assembling machine will detach it for you.) As a security measure, the elevator will only function if it contains at least one RTG or microchip. The elevator always stops on each floor to recharge, and this takes long enough that the items within it and the items on that floor can irradiate each other. (You can prevent this if a Microchip and its Generator end up on the same floor in this way, as they can be connected while the elevator is recharging.)</p>
<p>You make some notes of the locations of each component of interest (your puzzle input). Before you don a hazmat suit and start moving things around, you'd like to have an idea of what you need to do.</p>
<p>When you enter the containment area, you and the elevator will start on the first floor.</p>
<p>For example, suppose the isolated area has the following arrangement:</p>
<pre class="wrap"><code>The first floor contains a hydrogen-compatible microchip and a lithium-compatible microchip.
The second floor contains a hydrogen generator.
The third floor contains a lithium generator.
The fourth floor contains nothing relevant.
</code></pre>
<p>As a diagram (<code>F#</code> for a Floor number, <code>E</code> for Elevator, <code>H</code> for Hydrogen, <code>L</code> for Lithium, <code>M</code> for Microchip, and <code>G</code> for Generator), the initial state looks like this:</p>
<pre><code>F4 .  .  .  .  .  
F3 .  .  .  LG .  
F2 .  HG .  .  .  
F1 E  .  HM .  LM 
</code></pre>
<p>Then, to get everything up to the assembling machine on the fourth floor, the following steps could be taken:</p>
<ul>
<li><p>Bring the Hydrogen-compatible Microchip to the second floor, which is safe because it can get power from the Hydrogen Generator:</p><pre><code>F4 .  .  .  .  .  
F3 .  .  .  LG .  
F2 E  HG HM .  .  
F1 .  .  .  .  LM 
</code></pre></li>
<li><p>Bring both Hydrogen-related items to the third floor, which is safe because the Hydrogen-compatible microchip is getting power from its generator:</p><pre><code>F4 .  .  .  .  .  
F3 E  HG HM LG .  
F2 .  .  .  .  .  
F1 .  .  .  .  LM 
</code></pre></li>
<li><p>Leave the Hydrogen Generator on floor three, but bring the Hydrogen-compatible Microchip back down with you so you can still use the elevator:</p><pre><code>F4 .  .  .  .  .  
F3 .  HG .  LG .  
F2 E  .  HM .  .  
F1 .  .  .  .  LM 
</code></pre></li>
<li><p>At the first floor, grab the Lithium-compatible Microchip, which is safe because Microchips don't affect each other:</p><pre><code>F4 .  .  .  .  .  
F3 .  HG .  LG .  
F2 .  .  .  .  .  
F1 E  .  HM .  LM 
</code></pre></li>
<li><p>Bring both Microchips up one floor, where there is nothing to fry them:</p><pre><code>F4 .  .  .  .  .  
F3 .  HG .  LG .  
F2 E  .  HM .  LM 
F1 .  .  .  .  .  
</code></pre></li>
<li><p>Bring both Microchips up again to floor three, where they can be temporarily connected to their corresponding generators while the elevator recharges, preventing either of them from being fried:</p><pre><code>F4 .  .  .  .  .  
F3 E  HG HM LG LM 
F2 .  .  .  .  .  
F1 .  .  .  .  .  
</code></pre></li>
<li><p>Bring both Microchips to the fourth floor:</p><pre><code>F4 E  .  HM .  LM 
F3 .  HG .  LG .  
F2 .  .  .  .  .  
F1 .  .  .  .  .  
</code></pre></li>
<li><p>Leave the Lithium-compatible microchip on the fourth floor, but bring the Hydrogen-compatible one so you can still use the elevator; this is safe because although the Lithium Generator is on the destination floor, you can connect Hydrogen-compatible microchip to the Hydrogen Generator there:</p><pre><code>F4 .  .  .  .  LM 
F3 E  HG HM LG .  
F2 .  .  .  .  .  
F1 .  .  .  .  .  
</code></pre></li>
<li><p>Bring both Generators up to the fourth floor, which is safe because you can connect the Lithium-compatible Microchip to the Lithium Generator upon arrival:</p><pre><code>F4 E  HG .  LG LM 
F3 .  .  HM .  .  
F2 .  .  .  .  .  
F1 .  .  .  .  .  
</code></pre></li>
<li><p>Bring the Lithium Microchip with you to the third floor so you can use the elevator:</p><pre><code>F4 .  HG .  LG .  
F3 E  .  HM .  LM 
F2 .  .  .  .  .  
F1 .  .  .  .  .  
</code></pre></li>
<li><p>Bring both Microchips to the fourth floor:</p><pre><code>F4 E  HG HM LG LM 
F3 .  .  .  .  .  
F2 .  .  .  .  .  
F1 .  .  .  .  .  
</code></pre></li>
</ul>
<p>In this arrangement, it takes <code>11</code> steps to collect all of the objects at the fourth floor for assembly. (Each elevator stop counts as one step, even if nothing is added to or removed from it.)</p>
<p>In your situation, what is the <em>minimum number of steps</em> required to bring all of the objects to the fourth floor?</p>
</article>



<article class="day-desc"><h2>--- Day 12: Leonardo's Monorail ---</h2><p>You finally reach the top floor of this building: a garden with a slanted glass ceiling. Looks like there are no more stars to be had.</p>
<p>While sitting on a nearby bench amidst some <a href="https://www.google.com/search?q=tiger+lilies&tbm=isch">tiger lilies</a>, you manage to decrypt some of the files you extracted from the servers downstairs.</p>
<p>According to these documents, Easter Bunny HQ isn't just this building - it's a collection of buildings in the nearby area. They're all connected by a local monorail, and there's another building not far from here! Unfortunately, being night, the monorail is currently not operating.</p>
<p>You remotely connect to the monorail control systems and discover that the boot sequence expects a password. The password-checking logic (your puzzle input) is easy to extract, but the code it uses is strange: it's <span title="Strangely, this assembunny code doesn't seem to be very good at multiplying.">assembunny</span> code designed for the <a href="11">new computer</a> you just assembled. You'll have to execute the code and get the password.</p>
<p>The assembunny code you've extracted operates on four <a href="https://en.wikipedia.org/wiki/Processor_register">registers</a> (<code>a</code>, <code>b</code>, <code>c</code>, and <code>d</code>) that start at <code>0</code> and can hold any <a href="https://en.wikipedia.org/wiki/Integer">integer</a>. However, it seems to make use of only a few <a href="https://en.wikipedia.org/wiki/Instruction_set">instructions</a>:</p>
<ul>
<li><code>cpy x y</code> <em>copies</em> <code>x</code> (either an integer or the <em>value</em> of a register) into register <code>y</code>.</li>
<li><code>inc x</code> <em>increases</em> the value of register <code>x</code> by one.</li>
<li><code>dec x</code> <em>decreases</em> the value of register <code>x</code> by one.</li>
<li><code>jnz x y</code> <em>jumps</em> to an instruction <code>y</code> away (positive means forward; negative means backward), but only if <code>x</code> is <em>not zero</em>.</li>
</ul>
<p>The <code>jnz</code> instruction moves relative to itself: an offset of <code>-1</code> would continue at the previous instruction, while an offset of <code>2</code> would <em>skip over</em> the next instruction.</p>
<p>For example:</p>
<pre><code>cpy 41 a
inc a
inc a
dec a
jnz a 2
dec a
</code></pre>
<p>The above code would set register <code>a</code> to <code>41</code>, increase its value by <code>2</code>, decrease its value by <code>1</code>, and then skip the last <code>dec a</code> (because <code>a</code> is not zero, so the <code>jnz a 2</code> skips it), leaving register <code>a</code> at <code>42</code>. When you move past the last instruction, the program halts.</p>
<p>After executing the assembunny code in your puzzle input, <em>what value is left in register <code>a</code>?</em></p>
</article>



<article class="day-desc"><h2>--- Day 13: A Maze of Twisty Little Cubicles ---</h2><p>You arrive at the first floor of this new building to discover a much less welcoming environment than the shiny atrium of the last one.  Instead, you are in a maze of <span title="You are in a twisty alike of little cubicles, all maze.">twisty little cubicles</span>, all alike.</p>
<p>Every location in this area is addressed by a pair of non-negative integers (<code>x,y</code>). Each such coordinate is either a wall or an open space. You can't move diagonally. The cube maze starts at <code>0,0</code> and seems to extend infinitely toward <em>positive</em> <code>x</code> and <code>y</code>; negative values are <em>invalid</em>, as they represent a location outside the building. You are in a small waiting area at <code>1,1</code>.</p>
<p>While it seems chaotic, a nearby morale-boosting poster explains, the layout is actually quite logical. You can determine whether a given <code>x,y</code> coordinate will be a wall or an open space using a simple system:</p>
<ul>
<li>Find <code>x*x + 3*x + 2*x*y + y + y*y</code>.</li>
<li>Add the office designer's favorite number (your puzzle input).</li>
<li>Find the <a href="https://en.wikipedia.org/wiki/Binary_number">binary representation</a> of that sum; count the <em>number</em> of <a href="https://en.wikipedia.org/wiki/Bit">bits</a> that are <code>1</code>.
<ul>
<li>If the number of bits that are <code>1</code> is <em>even</em>, it's an <em>open space</em>.</li>
<li>If the number of bits that are <code>1</code> is <em>odd</em>, it's a <em>wall</em>.</li>
</ul>
</li>
</ul>
<p>For example, if the office designer's favorite number were <code>10</code>, drawing walls as <code>#</code> and open spaces as <code>.</code>, the corner of the building containing <code>0,0</code> would look like this:</p>
<pre><code>  0123456789
0 .#.####.##
1 ..#..#...#
2 #....##...
3 ###.#.###.
4 .##..#..#.
5 ..##....#.
6 #...##.###
</code></pre>
<p>Now, suppose you wanted to reach <code>7,4</code>. The shortest route you could take is marked as <code>O</code>:</p>
<pre><code>  0123456789
0 .#.####.##
1 .O#..#...#
2 #OOO.##...
3 ###O#.###.
4 .##OO#OO#.
5 ..##OOO.#.
6 #...##.###
</code></pre>
<p>Thus, reaching <code>7,4</code> would take a minimum of <code>11</code> steps (starting from your current location, <code>1,1</code>).</p>
<p>What is the <em>fewest number of steps required</em> for you to reach <code>31,39</code>?</p>
</article>



<article class="day-desc"><h2>--- Day 14: One-Time Pad ---</h2><p>In order to communicate securely with Santa while you're on this mission, you've been using a <a href="https://en.wikipedia.org/wiki/One-time_pad">one-time pad</a> that you <a href="https://en.wikipedia.org/wiki/Security_through_obscurity">generate</a> using a <span title="This also happens to be the plot of World War II.">pre-agreed algorithm</span>. Unfortunately, you've run out of keys in your one-time pad, and so you need to generate some more.</p>
<p>To generate keys, you first get a stream of random data by taking the <a href="https://en.wikipedia.org/wiki/MD5">MD5</a> of a pre-arranged <a href="https://en.wikipedia.org/wiki/Salt_(cryptography)">salt</a> (your puzzle input) and an increasing integer index (starting with <code>0</code>, and represented in decimal); the resulting MD5 hash should be represented as a string of <em>lowercase</em> hexadecimal digits.</p>
<p>However, not all of these MD5 hashes are <em>keys</em>, and you need <code>64</code> new keys for your one-time pad.  A hash is a key <em>only if</em>:</p>
<ul>
<li>It contains <em>three</em> of the same character in a row, like <code>777</code>. Only consider the first such triplet in a hash.</li>
<li>One of the next <code>1000</code> hashes in the stream contains that same character <em>five</em> times in a row, like <code>77777</code>.</li>
</ul>
<p>Considering future hashes for five-of-a-kind sequences does not cause those hashes to be skipped; instead, regardless of whether the current hash is a key, always resume testing for keys starting with the very next hash.</p>
<p>For example, if the pre-arranged salt is <code>abc</code>:</p>
<ul>
<li>The first index which produces a triple is <code>18</code>, because the MD5 hash of <code>abc18</code> contains <code>...cc38887a5...</code>. However, index <code>18</code> does not count as a key for your one-time pad, because none of the next thousand hashes (index <code>19</code> through index <code>1018</code>) contain <code>88888</code>.</li>
<li>The next index which produces a triple is <code>39</code>; the hash of <code>abc39</code> contains <code>eee</code>. It is also the first key: one of the next thousand hashes (the one at index 816) contains <code>eeeee</code>.</li>
<li>None of the next six triples are keys, but the one after that, at index <code>92</code>, is: it contains <code>999</code> and index <code>200</code> contains <code>99999</code>.</li>
<li>Eventually, index <code>22728</code> meets all of the criteria to generate the <code>64</code>th key.</li>
</ul>
<p>So, using our example salt of <code>abc</code>, index <code>22728</code> produces the <code>64</code>th key.</p>
<p>Given the actual salt in your puzzle input, <em>what index</em> produces your <code>64</code>th one-time pad key?</p>
</article>



<article class="day-desc"><h2>--- Day 15: Timing is Everything ---</h2><p>The halls open into an interior plaza containing a large kinetic sculpture. The sculpture is in a sealed enclosure and seems to involve a set of identical spherical capsules that are carried to the top and allowed to <a href="https://youtu.be/IxDoO9oODOk?t=177">bounce through the maze</a> of spinning pieces.</p>
<p>Part of the sculpture is even interactive! When a button is pressed, a capsule is dropped and tries to fall through slots in a set of rotating discs to finally go through a little hole at the bottom and come out of the sculpture. If any of the slots aren't aligned with the capsule as it passes, the capsule bounces off the disc and soars away. You feel compelled to <span title="These machines are everywhere in Japan, but on a MUCH smaller scale.">get one of those capsules</span>.</p>
<p>The discs pause their motion each second and come in different sizes; they seem to each have a fixed number of positions at which they stop.  You decide to call the position with the slot <code>0</code>, and count up for each position it reaches next.</p>
<p>Furthermore, the discs are spaced out so that after you push the button, one second elapses before the first disc is reached, and one second elapses as the capsule passes from one disc to the one below it.  So, if you push the button at <code>time=100</code>, then the capsule reaches the top disc at <code>time=101</code>, the second disc at <code>time=102</code>, the third disc at <code>time=103</code>, and so on.</p>
<p>The button will only drop a capsule at an integer time - no fractional seconds allowed.</p>
<p>For example, at <code>time=0</code>, suppose you see the following arrangement:</p>
<pre><code>Disc #1 has 5 positions; at time=0, it is at position 4.
Disc #2 has 2 positions; at time=0, it is at position 1.
</code></pre>
<p>If you press the button exactly at <code>time=0</code>, the capsule would start to fall; it would reach the first disc at <code>time=1</code>. Since the first disc was at position <code>4</code> at <code>time=0</code>, by <code>time=1</code> it has ticked one position forward.  As a five-position disc, the next position is <code>0</code>, and the capsule falls through the slot.</p>
<p>Then, at <code>time=2</code>, the capsule reaches the second disc. The second disc has ticked forward two positions at this point: it started at position <code>1</code>, then continued to position <code>0</code>, and finally ended up at position <code>1</code> again.  Because there's only a slot at position <code>0</code>, the capsule bounces away.</p>
<p>If, however, you wait until <code>time=5</code> to push the button, then when the capsule reaches each disc, the first disc will have ticked forward <code>5+1 = 6</code> times (to position <code>0</code>), and the second disc will have ticked forward <code>5+2 = 7</code> times (also to position <code>0</code>). In this case, the capsule would fall through the discs and come out of the machine.</p>
<p>However, your situation has more than two discs; you've noted their positions in your puzzle input. What is the <em>first time you can press the button</em> to get a capsule?</p>
</article>



<article class="day-desc"><h2>--- Day 16: Dragon Checksum ---</h2><p>You're done scanning this part of the network, but you've left traces of your presence. You need to <span title="If I ever find one of my disks overwritten with a dragon curve, I'll know it was you.">overwrite some disks</span> with random-looking data to cover your tracks and update the local security system with a new checksum for those disks.</p>
<p>For the data to not be suspicious, it needs to have certain properties; purely random data will be detected as tampering. To generate appropriate random data, you'll need to use a modified <a href="https://en.wikipedia.org/wiki/Dragon_curve">dragon curve</a>.</p>
<p>Start with an appropriate initial state (your puzzle input). Then, so long as you don't have enough data yet to fill the disk, repeat the following steps:</p>
<ul>
<li>Call the data you have at this point "a".</li>
<li>Make a copy of "a"; call this copy "b".</li>
<li>Reverse the order of the characters in "b".</li>
<li>In "b", replace all instances of <code>0</code> with <code>1</code> and all <code>1</code>s with <code>0</code>.</li>
<li>The resulting data is "a", then a single <code>0</code>, then "b".</li>
</ul>
<p>For example, after a single step of this process,</p>
<ul>
<li><code>1</code> becomes <code>100</code>.</li>
<li><code>0</code> becomes <code>001</code>.</li>
<li><code>11111</code> becomes <code>11111000000</code>.</li>
<li><code>111100001010</code> becomes <code>1111000010100101011110000</code>.</li>
</ul>
<p>Repeat these steps until you have enough data to fill the desired disk.</p>
<p>Once the data has been generated, you also need to create a checksum of that data. Calculate the checksum <em>only</em> for the data that fits on the disk, even if you generated more data than that in the previous step.</p>
<p>The checksum for some given data is created by considering each non-overlapping <em>pair</em> of characters in the input data.  If the two characters match (<code>00</code> or <code>11</code>), the next checksum character is a <code>1</code>.  If the characters do not match (<code>01</code> or <code>10</code>), the next checksum character is a <code>0</code>. This should produce a new string which is exactly half as long as the original. If the length of the checksum is <em>even</em>, repeat the process until you end up with a checksum with an <em>odd</em> length.</p>
<p>For example, suppose we want to fill a disk of length <code>12</code>, and when we finally generate a string of at least length <code>12</code>, the first <code>12</code> characters are <code>110010110100</code>. To generate its checksum:</p>
<ul>
<li>Consider each pair: <code>11</code>, <code>00</code>, <code>10</code>, <code>11</code>, <code>01</code>, <code>00</code>.</li>
<li>These are same, same, different, same, different, same, producing <code>110101</code>.</li>
<li>The resulting string has length <code>6</code>, which is <em>even</em>, so we repeat the process.</li>
<li>The pairs are <code>11</code> (same), <code>01</code> (different), <code>01</code> (different).</li>
<li>This produces the checksum <code>100</code>, which has an <em>odd</em> length, so we stop.</li>
</ul>
<p>Therefore, the checksum for <code>110010110100</code> is <code>100</code>.</p>
<p>Combining all of these steps together, suppose you want to fill a disk of length <code>20</code> using an initial state of <code>10000</code>:</p>
<ul>
<li>Because <code>10000</code> is too short, we first use the modified dragon curve to make it longer.</li>
<li>After one round, it becomes <code>10000011110</code> (<code>11</code> characters), still too short.</li>
<li>After two rounds, it becomes <code>10000011110010000111110</code> (<code>23</code> characters), which is enough.</li>
<li>Since we only need <code>20</code>, but we have <code>23</code>, we get rid of all but the first <code>20</code> characters: <code>10000011110010000111</code>.</li>
<li>Next, we start calculating the checksum; after one round, we have <code>0111110101</code>, which <code>10</code> characters long (<em>even</em>), so we continue.</li>
<li>After two rounds, we have <code>01100</code>, which is <code>5</code> characters long (<em>odd</em>), so we are done.</li>
</ul>
<p>In this example, the correct checksum would therefore be <code>01100</code>.</p>
<p>The first disk you have to fill has length <code>272</code>. Using the initial state in your puzzle input, <em>what is the correct checksum</em>?</p>
</article>



<article class="day-desc"><h2>--- Day 17: Two Steps Forward ---</h2><p>You're trying to access a secure vault protected by a <code>4x4</code> grid of small rooms connected by doors. You start in the top-left room (marked <code>S</code>), and you can access the vault (marked <code>V</code>) once you reach the bottom-right room:</p>
<pre><code>#########
#S| | | #
#-#-#-#-#
# | | | #
#-#-#-#-#
# | | | #
#-#-#-#-#
# | | |  
####### V
</code></pre>
<p>Fixed walls are marked with <code>#</code>, and doors are marked with <code>-</code> or <code>|</code>.</p>
<p>The doors in your <em>current room</em> are either open or closed (and locked) based on the hexadecimal <a href="https://en.wikipedia.org/wiki/MD5">MD5</a> hash of a passcode (your puzzle input) followed by a sequence of uppercase characters representing the <em>path you have taken so far</em> (<code>U</code> for up, <code>D</code> for down, <code>L</code> for left, and <code>R</code> for right).</p>
<p>Only the first four characters of the hash are used; they represent, respectively, the doors <em>up, down, left, and right</em> from your current position. Any <code>b</code>, <code>c</code>, <code>d</code>, <code>e</code>, or <code>f</code> means that the corresponding door is <em>open</em>; any other character (any number or <code>a</code>) means that the corresponding door is <em>closed and locked</em>.</p>
<p>To access the vault, all you need to do is reach the bottom-right room; reaching this room opens the vault and all doors in the maze.</p>
<p>For example, suppose the passcode is <code>hijkl</code>. Initially, you have taken no steps, and so your path is empty: you simply find the MD5 hash of <code>hijkl</code> alone. The first four characters of this hash are <code>ced9</code>, which indicate that up is open (<code>c</code>), down is open (<code>e</code>), left is open (<code>d</code>), and right is closed and locked (<code>9</code>). Because you start in the top-left corner, there are no "up" or "left" doors to be open, so your only choice is <em>down</em>.</p>
<p>Next, having gone only one step (down, or <code>D</code>), you find the hash of <code>hijkl<em>D</em></code>. This produces <code>f2bc</code>, which indicates that you can go back up, left (but that's a wall), or right. Going right means hashing <code>hijkl<em>DR</em></code> to get <code>5745</code> - all doors closed and locked. However, going <em>up</em> instead is worthwhile: even though it returns you to the room you started in, your path would then be <code>DU</code>, opening a <em>different set of doors</em>.</p>
<p>After going <code>DU</code> (and then hashing <code>hijkl<em>DU</em></code> to get <code>528e</code>), only the right door is open; after going <code>DUR</code>, all doors lock. (Fortunately, your actual passcode is <span title="It took four days to rescue the engineer that tried this.">not <code>hijkl</code></span>).</p>
<p>Passcodes actually used by Easter Bunny Vault Security do allow access to the vault if you know the right path.  For example:</p>
<ul>
<li>If your passcode were <code>ihgpwlah</code>, the shortest path would be <code>DDRRRD</code>.</li>
<li>With <code>kglvqrro</code>, the shortest path would be <code>DDUDRLRRUDRD</code>.</li>
<li>With <code>ulqzkmiv</code>, the shortest would be <code>DRURDRUDDLLDLUURRDULRLDUUDDDRR</code>.</li>
</ul>
<p>Given your vault's passcode, <em>what is the shortest path</em> (the actual path, not just the length) to reach the vault?</p>
</article>



<article class="day-desc"><h2>--- Day 18: Like a Rogue ---</h2><p>As you enter this room, you hear a loud click! Some of the tiles in the floor here seem to be pressure plates for <a href="https://nethackwiki.com/wiki/Trap">traps</a>, and the trap you just triggered has run out of... whatever it tried to do to you. You doubt you'll be so lucky next time.</p>
<p>Upon closer examination, the traps and safe tiles in this room seem to follow a pattern. The tiles are arranged into rows that are all the same width; you take note of the safe tiles (<code>.</code>) and traps (<code>^</code>) in the first row (your puzzle input).</p>
<p>The type of tile (trapped or safe) in each row is based on the types of the tiles in the same position, and to either side of that position, in the previous row. (If either side is off either end of the row, it counts as "safe" because there isn't a trap embedded in the wall.)</p>
<p>For example, suppose you know the first row (with tiles marked by letters) and want to determine the next row (with tiles marked by numbers):</p>
<pre><code>ABCDE
12345
</code></pre>
<p>The type of tile <code>2</code> is based on the types of tiles <code>A</code>, <code>B</code>, and <code>C</code>; the type of tile <code>5</code> is based on tiles <code>D</code>, <code>E</code>, and an imaginary "safe" tile. Let's call these three tiles from the previous row the <em>left</em>, <em>center</em>, and <em>right</em> tiles, respectively. Then, a new tile is a <em>trap</em> only in one of the following situations:</p>
<ul>
<li>Its <em>left</em> and <em>center</em> tiles are traps, but its <em>right</em> tile is not.</li>
<li>Its <em>center</em> and <em>right</em> tiles are traps, but its <em>left</em> tile is not.</li>
<li>Only its <em>left</em> tile is a trap.</li>
<li>Only its <em>right</em> tile is a trap.</li>
</ul>
<p>In any other situation, the new tile is safe.</p>
<p>Then, starting with the row <code>..^^.</code>, you can determine the next row by applying those rules to each new tile:</p>
<ul>
<li>The leftmost character on the next row considers the left (nonexistent, so we assume "safe"), center (the first <code>.</code>, which means "safe"), and right (the second <code>.</code>, also "safe") tiles on the previous row. Because all of the trap rules require a trap in at least one of the previous three tiles, the first tile on this new row is also safe, <code>.</code>.</li>
<li>The second character on the next row considers its left (<code>.</code>), center (<code>.</code>), and right (<code>^</code>) tiles from the previous row. This matches the fourth rule: only the right tile is a trap. Therefore, the next tile in this new row is a trap, <code>^</code>.</li>
<li>The third character considers <code>.^^</code>, which matches the second trap rule: its center and right tiles are traps, but its left tile is not. Therefore, this tile is also a trap, <code>^</code>.</li>
<li>The last two characters in this new row match the first and third rules, respectively, and so they are both also traps, <code>^</code>.</li>
</ul>
<p>After these steps, we now know the next row of tiles in the room: <code>.^^^^</code>. Then, we continue on to the next row, using the same rules, and get <code>^^..^</code>. After determining two new rows, our map looks like this:</p>
<pre><code>..^^.
.^^^^
^^..^
</code></pre>
<p>Here's a larger example with ten tiles per row and ten rows:</p>
<pre><code>.^^.^.^^^^
^^^...^..^
^.^^.^.^^.
..^^...^^^
.^^^^.^^.^
^^..^.^^..
^^^^..^^^.
^..^^^^.^^
.^^^..^.^^
^^.^^^..^^
</code></pre>
<p>In ten rows, this larger example has <code>38</code> safe tiles.</p>
<p>Starting with the map in your puzzle input, in a total of <code>40</code> rows (including the starting row), <em>how many safe tiles</em> are there?</p>
</article>



<article class="day-desc"><h2>--- Day 19: An Elephant Named Joseph ---</h2><p>The Elves contact you over a highly secure emergency channel. Back at the North Pole, the Elves are busy <span title="Eggnoggedly misunderstanding them, actually.">misunderstanding</span> <a href="https://en.wikipedia.org/wiki/White_elephant_gift_exchange">White Elephant parties</a>.</p>
<p>Each Elf brings a present. They all sit in a circle, numbered starting with position <code>1</code>. Then, starting with the first Elf, they take turns stealing all the presents from the Elf to their left.  An Elf with no presents is removed from the circle and does not take turns.</p>
<p>For example, with five Elves (numbered <code>1</code> to <code>5</code>):</p>
<pre><code>  1
5   2
 4 3
</code></pre>
<ul>
<li>Elf <code>1</code> takes Elf <code>2</code>'s present.</li>
<li>Elf <code>2</code> has no presents and is skipped.</li>
<li>Elf <code>3</code> takes Elf <code>4</code>'s present.</li>
<li>Elf <code>4</code> has no presents and is also skipped.</li>
<li>Elf <code>5</code> takes Elf <code>1</code>'s two presents.</li>
<li>Neither Elf <code>1</code> nor Elf <code>2</code> have any presents, so both are skipped.</li>
<li>Elf <code>3</code> takes Elf <code>5</code>'s three presents.</li>
</ul>
<p>So, with <em>five</em> Elves, the Elf that sits starting in position <code>3</code> gets all the presents.</p>
<p>With the number of Elves given in your puzzle input, <em>which Elf gets all the presents?</em></p>
</article>



<article class="day-desc"><h2>--- Day 20: Firewall Rules ---</h2><p>You'd like to set up a small hidden computer here so you can use it to <span title="I'll create a GUI interface using Visual Basic... see if I can track an IP address.">get back into the network</span> later. However, the corporate firewall only allows communication with certain external <a href="https://en.wikipedia.org/wiki/IPv4#Addressing">IP addresses</a>.</p>
<p>You've retrieved the list of blocked IPs from the firewall, but the list seems to be messy and poorly maintained, and it's not clear which IPs are allowed. Also, rather than being written in <a href="https://en.wikipedia.org/wiki/Dot-decimal_notation">dot-decimal</a> notation, they are written as plain <a href="https://en.wikipedia.org/wiki/32-bit">32-bit integers</a>, which can have any value from <code>0</code> through <code>4294967295</code>, inclusive.</p>
<p>For example, suppose only the values <code>0</code> through <code>9</code> were valid, and that you retrieved the following blacklist:</p>
<pre><code>5-8
0-2
4-7
</code></pre>
<p>The blacklist specifies ranges of IPs (inclusive of both the start and end value) that are <em>not</em> allowed. Then, the only IPs that this firewall allows are <code>3</code> and <code>9</code>, since those are the only numbers not in any range.</p>
<p>Given the list of blocked IPs you retrieved from the firewall (your puzzle input), <em>what is the lowest-valued IP</em> that is not blocked?</p>
</article>



<article class="day-desc"><h2>--- Day 21: Scrambled Letters and Hash ---</h2><p>The computer system you're breaking into uses a <span title="I do not like them, Security-Account-Manager-I-Am! I do not like scrambled letters and hash!">weird scrambling function</span> to store its passwords. It shouldn't be much trouble to create your own scrambled password so you can add it to the system; you just have to implement the scrambler.</p>
<p>The scrambling function is a series of operations (the exact list is provided in your puzzle input). Starting with the password to be scrambled, apply each operation in succession to the string. The individual operations behave as follows:</p>
<ul>
<li><code>swap position X with position Y</code> means that the letters at indexes <code>X</code> and <code>Y</code> (counting from <code>0</code>) should be <em>swapped</em>.</li>
<li><code>swap letter X with letter Y</code> means that the letters <code>X</code> and <code>Y</code> should be <em>swapped</em> (regardless of where they appear in the string).</li>
<li><code>rotate left/right X steps</code> means that the whole string should be <em>rotated</em>; for example, one right rotation would turn <code>abcd</code> into <code>dabc</code>.</li>
<li><code>rotate based on position of letter X</code> means that the whole string should be <em>rotated to the right</em> based on the <em>index</em> of letter <code>X</code> (counting from <code>0</code>) as determined <em>before</em> this instruction does any rotations.  Once the index is determined, rotate the string to the right one time, plus a number of times equal to that index, plus one additional time if the index was at least <code>4</code>.</li>
<li><code>reverse positions X through Y</code> means that the span of letters at indexes <code>X</code> through <code>Y</code> (including the letters at <code>X</code> and <code>Y</code>) should be <em>reversed in order</em>.</li>
<li><code>move position X to position Y</code> means that the letter which is at index <code>X</code> should be <em>removed</em> from the string, then <em>inserted</em> such that it ends up at index <code>Y</code>.</li>
</ul>
<p>For example, suppose you start with <code>abcde</code> and perform the following operations:</p>
<ul>
<li><code>swap position 4 with position 0</code> swaps the first and last letters, producing the input for the next step, <code>ebcda</code>.</li>
<li><code>swap letter d with letter b</code> swaps the positions of <code>d</code> and <code>b</code>: <code>edcba</code>.</li>
<li><code>reverse positions 0 through 4</code> causes the entire string to be reversed, producing <code>abcde</code>.</li>
<li><code>rotate left 1 step</code> shifts all letters left one position, causing the first letter to wrap to the end of the string: <code>bcdea</code>.</li>
<li><code>move position 1 to position 4</code> removes the letter at position <code>1</code> (<code>c</code>), then inserts it at position <code>4</code> (the end of the string): <code>bdeac</code>.</li>
<li><code>move position 3 to position 0</code> removes the letter at position <code>3</code> (<code>a</code>), then inserts it at position <code>0</code> (the front of the string): <code>abdec</code>.</li>
<li><code>rotate based on position of letter b</code> finds the index of letter <code>b</code> (<code>1</code>), then rotates the string right once plus a number of times equal to that index (<code>2</code>): <code>ecabd</code>.</li>
<li><code>rotate based on position of letter d</code> finds the index of letter <code>d</code> (<code>4</code>), then rotates the string right once, plus a number of times equal to that index, plus an additional time because the index was at least <code>4</code>, for a total of <code>6</code> right rotations: <code>decab</code>.</li>
</ul>
<p>After these steps, the resulting scrambled password is <code>decab</code>.</p>
<p>Now, you just need to generate a new scrambled password and you can access the system. Given the list of scrambling operations in your puzzle input, <em>what is the result of scrambling <code>abcdefgh</code></em>?</p>
</article>



<article class="day-desc"><h2>--- Day 22: Grid Computing ---</h2><p>You gain access to a massive storage cluster arranged in a grid; each storage node is only connected to the four nodes directly adjacent to it (three if the node is on an edge, two if it's in a corner).</p>
<p>You can directly access data <em>only</em> on node <code>/dev/grid/node-x0-y0</code>, but you can perform some limited actions on the other nodes:</p>
<ul>
<li>You can get the disk usage of all nodes (via <a href="https://en.wikipedia.org/wiki/Df_(Unix)#Example"><code>df</code></a>). The result of doing this is in your puzzle input.</li>
<li>You can instruct a node to <span title="You suspect someone misunderstood the x86 MOV instruction."><em>move</em></span> (not copy) <em>all</em> of its data to an adjacent node (if the destination node has enough space to receive the data). The sending node is left empty after this operation.</li>
</ul>
<p>Nodes are named by their position: the node named <code>node-x10-y10</code> is adjacent to nodes <code>node-x9-y10</code>, <code>node-x11-y10</code>, <code>node-x10-y9</code>, and <code>node-x10-y11</code>.</p>
<p>Before you begin, you need to understand the arrangement of data on these nodes. Even though you can only move data between directly connected nodes, you're going to need to rearrange a lot of the data to get access to the data you need.  Therefore, you need to work out how you might be able to shift data around.</p>
<p>To do this, you'd like to count the number of <em>viable pairs</em> of nodes.  A viable pair is any two nodes (A,B), <em>regardless of whether they are directly connected</em>, such that:</p>
<ul>
<li>Node A is <em>not</em> empty (its <code>Used</code> is not zero).</li>
<li>Nodes A and B are <em>not the same</em> node.</li>
<li>The data on node A (its <code>Used</code>) <em>would fit</em> on node B (its <code>Avail</code>).</li>
</ul>
<p><em>How many viable pairs</em> of nodes are there?</p>
</article>



<article class="day-desc"><h2>--- Day 23: Safe Cracking ---</h2><p>This is one of the top floors of the nicest tower in EBHQ. The Easter Bunny's private office is here, complete with a safe hidden behind a painting, and who <em>wouldn't</em> hide a star in a safe behind a painting?</p>
<p>The safe has a digital screen and keypad for code entry. A sticky note attached to the safe has a password hint on it: "eggs". The painting is of a large rabbit coloring some eggs. You see <code>7</code>.</p>
<p>When you go to type the code, though, nothing appears on the display; instead, the keypad comes apart in your hands, apparently having been smashed. Behind it is some kind of socket - one that matches a connector in your <a href="11">prototype computer</a>! You pull apart the smashed keypad and extract the logic circuit, plug it into your computer, and plug your computer into the safe.</p>
</p>Now, you just need to figure out what output the keypad would have sent to the safe. You extract the <a href="12">assembunny code</a> from the logic chip (your puzzle input).</p>
<p>The code looks like it uses <em>almost</em> the same architecture and instruction set that the <a href="12">monorail computer</a> used! You should be able to <em>use the same assembunny interpreter</em> for this as you did there, but with one new instruction:</p>
<p><code>tgl x</code> <em>toggles</em> the instruction <code>x</code> away (pointing at instructions like <code>jnz</code> does: positive means forward; negative means backward):</p>
<ul>
<li>For <em>one-argument</em> instructions, <code>inc</code> becomes <code>dec</code>, and all other one-argument instructions become <code>inc</code>.</li>
<li>For <em>two-argument</em> instructions, <code>jnz</code> becomes <code>cpy</code>, and all other two-instructions become <code>jnz</code>.</li>
<li>The arguments of a toggled instruction are <em>not affected</em>.</li>
<li>If an attempt is made to toggle an instruction outside the program, <em>nothing happens</em>.</li>
<li>If toggling produces an <em>invalid instruction</em> (like <code>cpy 1 2</code>) and an attempt is later made to execute that instruction, <em>skip it instead</em>.</li>
<li>If <code>tgl</code> toggles <em>itself</em> (for example, if <code>a</code> is <code>0</code>, <code>tgl a</code> would target itself and become <code>inc a</code>), the resulting instruction is not executed until the next time it is reached.</li>
</ul>
<p>For example, given this program:</p>
<pre><code>cpy 2 a
tgl a
tgl a
tgl a
cpy 1 a
dec a
dec a
</code></pre>
<ul>
<li><code>cpy 2 a</code> initializes register <code>a</code> to <code>2</code>.</li>
<li>The first <code>tgl a</code> toggles an instruction <code>a</code> (<code>2</code>) away from it, which changes the third <code>tgl a</code> into <code>inc a</code>.</li>
<li>The second <code>tgl a</code> also modifies an instruction <code>2</code> away from it, which changes the <code>cpy 1 a</code> into <code>jnz 1 a</code>.</li>
<li>The fourth line, which is now <code>inc a</code>, increments <code>a</code> to <code>3</code>.</li>
<li>Finally, the fifth line, which is now <code>jnz 1 a</code>, jumps <code>a</code> (<code>3</code>) instructions ahead, skipping the <code>dec a</code> instructions.</li>
</ul>
<p>In this example, the final value in register <code>a</code> is <code>3</code>.</p>
<p>The rest of the electronics seem to place the keypad entry (the number of eggs, <code>7</code>) in register <code>a</code>, run the code, and then send the value left in register <code>a</code> to the safe.</p>
<p><em>What value</em> should be sent to the safe?</p>
</article>



<article class="day-desc"><h2>--- Day 24: Air Duct Spelunking ---</h2><p>You've finally met your match; the doors that provide access to the roof are locked tight, and all of the controls and related electronics are inaccessible. You simply can't reach them.</p>
<p>The robot that cleans the air ducts, however, <em>can</em>.</p>
<p>It's not a very fast <span title="The Brave Little Air Duct Cleaning Robot That Could">little robot</span>, but you reconfigure it to be able to interface with some of the exposed wires that have been routed through the <a href="https://en.wikipedia.org/wiki/HVAC">HVAC</a> system. If you can direct it to each of those locations, you should be able to bypass the security controls.</p>
<p>You extract the duct layout for this area from some blueprints you acquired and create a map with the relevant locations marked (your puzzle input). <code>0</code> is your current location, from which the cleaning robot embarks; the other numbers are (in <em>no particular order</em>) the locations the robot needs to visit at least once each. Walls are marked as <code>#</code>, and open passages are marked as <code>.</code>. Numbers behave like open passages.</p>
<p>For example, suppose you have a map like the following:</p>
<pre><code>###########
#0.1.....2#
#.#######.#
#4.......3#
###########
</code></pre>
<p>To reach all of the points of interest as quickly as possible, you would have the robot take the following path:</p>
<ul>
<li><code>0</code> to <code>4</code> (<code>2</code> steps)</li>
<li><code>4</code> to <code>1</code> (<code>4</code> steps; it can't move diagonally)</li>
<li><code>1</code> to <code>2</code> (<code>6</code> steps)</li>
<li><code>2</code> to <code>3</code> (<code>2</code> steps)</li>
</ul>
<p>Since the robot isn't very fast, you need to find it the <em>shortest route</em>. This path is the fewest steps (in the above example, a total of <code>14</code>) required to start at <code>0</code> and then visit every other location at least once.</p>
<p>Given your actual map, and starting from location <code>0</code>, what is the <em>fewest number of steps</em> required to visit every non-<code>0</code> number marked on the map at least once?</p>
</article>



<article class="day-desc"><h2>--- Day 25: Clock Signal ---</h2><p>You open the door and find yourself on the roof. The city sprawls away from you for miles and miles.</p>
<p>There's not much time now - it's already Christmas, but you're nowhere near the North Pole, much too far to deliver these stars to the sleigh in time.</p>
<p>However, maybe the <em>huge antenna</em> up here can offer a solution. After all, the sleigh doesn't need the stars, exactly; it needs the timing data they provide, and you happen to have a massive signal generator right here.</p>
<p>You connect the stars you have to your prototype computer, connect that to the antenna, and begin the transmission.</p>
<p><span title="Then again, if something ever works on the first try, you should be *very* suspicious.">Nothing happens.</span></p>
<p>You call the service number printed on the side of the antenna and quickly explain the situation. "I'm not sure what kind of equipment you have connected over there," he says, "but you need a clock signal." You try to explain that this is a signal for a clock.</p>
<p>"No, no, a <a href="https://en.wikipedia.org/wiki/Clock_signal">clock signal</a> - timing information so the antenna computer knows how to read the data you're sending it. An endless, alternating pattern of <code>0</code>, <code>1</code>, <code>0</code>, <code>1</code>, <code>0</code>, <code>1</code>, <code>0</code>, <code>1</code>, <code>0</code>, <code>1</code>...." He trails off.</p>
<p>You ask if the antenna can handle a clock signal at the frequency you would need to use for the data from the stars. "There's <em>no way</em> it can! The only antenna we've installed capable of <em>that</em> is on top of a top-secret Easter Bunny installation, and you're <em>definitely</em> not-" You hang up the phone.</p>
<p>You've extracted the antenna's clock signal generation <a href="12">assembunny</a> code (your puzzle input); it looks mostly compatible with code you worked on <a href="23">just recently</a>.</p>
<p>This antenna code, being a signal generator, uses one extra instruction:</p>
<ul>
<li><code>out x</code> <em>transmits</em> <code>x</code> (either an integer or the <em>value</em> of a register) as the next value for the clock signal.</li>
</ul>
<p>The code takes a value (via register <code>a</code>) that describes the signal to generate, but you're not sure how it's used. You'll have to find the input to produce the right signal through experimentation.</p>
<p><em>What is the lowest positive integer</em> that can be used to initialize register <code>a</code> and cause the code to output a clock signal of <code>0</code>, <code>1</code>, <code>0</code>, <code>1</code>... repeating forever?</p>
</article>
