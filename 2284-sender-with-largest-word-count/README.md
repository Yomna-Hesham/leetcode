<h2><a href="https://leetcode.com/problems/sender-with-largest-word-count/">2284. Sender With Largest Word Count</a></h2><h3>Medium</h3><hr><div style="user-select: auto;"><p style="user-select: auto;">You have a chat log of <code style="user-select: auto;">n</code> messages. You are given two string arrays <code style="user-select: auto;">messages</code> and <code style="user-select: auto;">senders</code> where <code style="user-select: auto;">messages[i]</code> is a <strong style="user-select: auto;">message</strong> sent by <code style="user-select: auto;">senders[i]</code>.</p>

<p style="user-select: auto;">A <strong style="user-select: auto;">message</strong> is list of <strong style="user-select: auto;">words</strong> that are separated by a single space with no leading or trailing spaces. The <strong style="user-select: auto;">word count</strong> of a sender is the total number of <strong style="user-select: auto;">words</strong> sent by the sender. Note that a sender may send more than one message.</p>

<p style="user-select: auto;">Return <em style="user-select: auto;">the sender with the <strong style="user-select: auto;">largest</strong> word count</em>. If there is more than one sender with the largest word count, return <em style="user-select: auto;">the one with the <strong style="user-select: auto;">lexicographically largest</strong> name</em>.</p>

<p style="user-select: auto;"><strong style="user-select: auto;">Note:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;">Uppercase letters come before lowercase letters in lexicographical order.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">"Alice"</code> and <code style="user-select: auto;">"alice"</code> are distinct.</li>
</ul>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> messages = ["Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"], senders = ["Alice","userTwo","userThree","Alice"]
<strong style="user-select: auto;">Output:</strong> "Alice"
<strong style="user-select: auto;">Explanation:</strong> Alice sends a total of 2 + 3 = 5 words.
userTwo sends a total of 2 words.
userThree sends a total of 3 words.
Since Alice has the largest word count, we return "Alice".
</pre>

<p style="user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> messages = ["How is leetcode for everyone","Leetcode is useful for practice"], senders = ["Bob","Charlie"]
<strong style="user-select: auto;">Output:</strong> "Charlie"
<strong style="user-select: auto;">Explanation:</strong> Bob sends a total of 5 words.
Charlie sends a total of 5 words.
Since there is a tie for the largest word count, we return the sender with the lexicographically larger name, Charlie.</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">n == messages.length == senders.length</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= n &lt;= 10<sup style="user-select: auto;">4</sup></code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= messages[i].length &lt;= 100</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= senders[i].length &lt;= 10</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">messages[i]</code> consists of uppercase and lowercase English letters and <code style="user-select: auto;">' '</code>.</li>
	<li style="user-select: auto;">All the words in <code style="user-select: auto;">messages[i]</code> are separated by <strong style="user-select: auto;">a single space</strong>.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">messages[i]</code> does not have leading or trailing spaces.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">senders[i]</code> consists of uppercase and lowercase English letters only.</li>
</ul>
</div>