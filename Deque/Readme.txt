This is a Deque with fixed size, which should be restricted
At the beginning of input. The deque can handle command 
such as "PushLeft "+ arguments or "PollLeft", it will return the
element added or feteched. The deque will also indicate if it 
is out of capacity, or no element to pop.

The input format should be like this:
3 4
PushLeft 1
PushRight -1
PushRight 3
PollLeft

Output should be
Push Left 1
Push Right -1
Push Right 3
Poll Left 1