<style>
main {
  background: #0f0f23; 
  color: #cccccc;
  font-family: courier;
  font-size: 12pt;
  padding: 20px;
  padding-top: 1px;
}
a { outline:0; }
pre, code { font-family: courier; }
a {
  text-decoration: none;
  color: #009900;
}
a:hover {
  color: #99ff99;
}
h1, h2 {
  font-size: 1em;
  font-weight: normal;
}
span.code-inline {
  display: inline;
  margin: 0;
  padding: 0;
  border: 1px solid #333340;    
  background: #10101a;
}
span.code-block {
  display: block;
  margin: 10px;
  padding: 10px;
  box-sizing: border-box;
  border: 1px solid #333340;    
  background: #10101a;
}
.quiet {
  opacity: .5;
}
p.wrap {
  width: 45em;
}
.hidden {
  border: 1px dotted gray;
  overflow: hidden;
  position: relative;
  padding: 0 .5em;
}
.hidden:before {
  content: "(hover to view)";
  position: absolute;
  opacity: .5;
  text-align: center;
  left: 0;
  top: 0;
  width: 100%;
}
.hidden > * {
  visibility: hidden;
}
.hidden:hover {
  border-color: transparent;
}
.hidden:hover:before {
  display: none;
}
.hidden:hover > * {
  visibility: visible;
}
.supporter {
  color: #ffff66;
}
a.supporter:hover {
  text-decoration: none;
  color: #ffffcc;
  text-shadow: 0 0 5px #ffff66;
}
header {
  white-space: nowrap;
  cursor: default;
  z-index: 100;
  margin-bottom: 2em;
}
header h1 {
  display: inline-block;
  margin: 0;
  padding-right: 1em;
}
header h1 a, header h1 span {
  display: inline-block;
  text-decoration: none;
  color: #00cc00;
  text-shadow: 0 0 2px #00cc00, 0 0 5px #00cc00;
}
header h1 a:hover {
  color: #99ff99;
  text-shadow: 0 0 2px #99ff99, 0 0 5px #99ff99;
}
header h1.title-event .title-event-wrap {
  opacity: .33;
}
header .user {
  display: inline-block;
  padding-left: 1em;
}
header .user .star-count {
  color: #ffff66;
}
header nav {
  display: inline-block;
}
header nav ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
  display: inline-block;
}
header nav li {
  display: inline-block;
  padding: 0 .5em;
}
header nav a {
  display: inline-block;
  text-decoration: none;
  outline: none;
}
input[type="text"] {
  background: transparent;
  color: inherit;
  border: 1px solid #666666;
  background: #10101a;
  padding: 0 2px;
  font-family: inherit;
  font-size: inherit;
  margin: 0;
}
input[type="submit"] {
  background: transparent;
  border: 0;
  font-family: inherit;
  font-size: inherit;
  margin: 0;
  padding: 0;
  color: #009900;
  cursor: pointer;
}
input[type="submit"]:hover {
  color: #99ff99;
}
*::-moz-focus-inner {
  padding: 0;
  border: 0
}
article {
  width: 45em;
  margin-bottom: 2em;
  margin-top: 2em;
}
article:first-child {
  margin-top: 0;
}
article h2 {
  color: #ffffff;
  margin-top: 1em;
  margin-bottom: 1em;
  white-space: nowrap;
}
article h2 + * {
  margin-top: 0;
}
article em {
  color: #ffffff;
  font-style: normal;
  text-shadow: 0 0 5px #ffffff;
}
article em.star {
  color: #ffff66;
  font-style: normal;
  text-shadow: 0 0 5px #ffff66;
}
article a {
  white-space: nowrap;
}
article .aside {
  opacity: .6;
}
article ul {
  list-style-type: none;
  padding: 0;
}
article li {
  padding-left: 2.5em;
  position: relative;
}
article li:before {
  content: "\00a0\00a0-\00a0";
  position: absolute;
  left: 0;
  top: 0;
}
</style>

<main>

<article class="day-desc"><h2>--- Day 1: No Time for a Taxicab ---</h2>
<p>Santa's sleigh uses a <span title="An atomic clock is too inaccurate; he might end up in a wall!">very high-precision clock</span> to guide its movements, and the clock's oscillator is regulated by stars. Unfortunately, the stars have been stolen... by the Easter Bunny.  To save Christmas, Santa needs you to retrieve all <em class="star">fifty stars</em> by December 25th.</p>
<p>Collect stars by solving puzzles.  Two puzzles will be made available on each day in the advent calendar; the second puzzle is unlocked when you complete the first.  Each puzzle grants <em class="star">one star</em>. Good luck!</p>
<p>You're airdropped near <em>Easter Bunny Headquarters</em> in a city somewhere.  "Near", unfortunately, is as close as you can get - the instructions on the Easter Bunny Recruiting Document the Elves intercepted start here, and nobody had time to work them out further.</p>
<p>The Document indicates that you should start at the given coordinates (where you just landed) and face North.  Then, follow the provided sequence: either turn left (<span class="code-inline">L</span>) or right (<span class="code-inline">R</span>) 90 degrees, then walk forward the given number of blocks, ending at a new intersection.</p>
<p>There's no time to follow such ridiculous instructions on foot, though, so you take a moment and work out the destination.  Given that you can only walk on the <a href="https://en.wikipedia.org/wiki/Taxicab_geometry">street grid of the city</a>, how far is the shortest path to the destination?</p>
<p>For example:</p>
<ul>
<li>Following <span class="code-inline">R2, L3</span> leaves you <span class="code-inline">2</span> blocks East and <span class="code-inline">3</span> blocks North, or <span class="code-inline">5</span> blocks away.</li>
<li><span class="code-inline">R2, R2, R2</span> leaves you <span class="code-inline">2</span> blocks due South of your starting position, which is <span class="code-inline">2</span> blocks away.</li>
<li><span class="code-inline">R5, L5, R5, R3</span> leaves you <span class="code-inline">12</span> blocks away.</li>
</ul>
<p><em>How many blocks away</em> is Easter Bunny HQ?</p>
</article>


<article class="day-desc"><h2>--- Day 2: Bathroom Security ---</h2><p>You arrive at <em>Easter Bunny Headquarters</em> under cover of darkness. However, you left in such a rush that you forgot to use the bathroom! Fancy office buildings like this one usually have keypad locks on their bathrooms, so you search the front desk for the code.</p>
<p>"In order to improve security," the document you find says, "bathroom codes will no longer be written down.  Instead, please memorize and follow the procedure below to access the bathrooms."</p>
<p>The document goes on to explain that each button to be pressed can be found by starting on the previous button and moving to adjacent buttons on the keypad: <span class="code-inline">U</span> moves up, <span class="code-inline">D</span> moves down, <span class="code-inline">L</span> moves left, and <span class="code-inline">R</span> moves right. Each line of instructions corresponds to one button, starting at the previous button (or, for the first line, <em>the "5" button</em>); press whatever button you're on at the end of each line. If a move doesn't lead to a button, ignore it.</p>
<p>You can't hold it much longer, so you decide to figure out the code as you walk to the bathroom. You picture a keypad like this:</p>
<span class="code-block" style="width: 4.5em;">1 2 3
4 5 6
7 8 9
</span>
<p>Suppose your instructions are:</p>
<span class="code-block" style="width: 4.5em;">ULL
RRDDD
LURDL
UUUUD
</span>
<ul>
<li>You start at "5" and move up (to "2"), left (to "1"), and left (you can't, and stay on "1"), so the first button is <span class="code-inline">1</span>.</li>
<li>Starting from the previous button ("1"), you move right twice (to "3") and then down three times (stopping at "9" after two moves and ignoring the third), ending up with <span class="code-inline">9</span>.</li>
<li>Continuing from "9", you move left, up, right, down, and left, ending with <span class="code-inline">8</span>.</li>
<li>Finally, you move up four times (stopping at "2"), then down once, ending with <span class="code-inline">5</span>.</li>
</ul>
<p>So, in this example, the bathroom code is <span class="code-inline">1985</span>.</p>
<p>Your puzzle input is the instructions from the document you found at the front desk. What is the <em>bathroom code</em>?</p>
</article>


</main>