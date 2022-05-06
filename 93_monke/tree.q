AKH+D:: Ariella Katz, Kaitlin Ho, Hugo Jenkins
APCS pd6
HW93 -- exploring tree properties, extracting actionable intel from traversals
2022-05-05r
time spent: 0.5 hrs


DISCO
------------------------------------------------
* The first letter in pre-order is the root
* Both in-order and pre-order "lean left"
================================================


QCC
------------------------------------------------
* Balanced trees are visually not balanced.
* Where do balanced trees occur in nature?
* The LORAX would like this unit, but he will not speak to us regarding the
trees.
================================================


SELF-ASSESSMENT PROMPTS
------------------------------------------------
In which direction does a tree grow?
down

Provide as many alternate definitions as you can for "tree," using graph
terminology ("closed/open tours", "paths", "cycles", etc). Maximize clarity,
succinctness.
A tree is...
  a graph with bidirectional edges where either one or two paths stem from a
  node, and if two paths, they connect different pairs of nodes.
  a set of nodes connected bidirectionally with a single path for each pair.
  a graph with roots and leaves.

Why is a balanced tree allowed a difference of 1 in height between right and
left subtrees?
Balanced trees may have this characteristic because it is an inherent part of
their definition. If traversing to a new level may be considered one "process",
as long as a level has at least one node, it requires another process. So,
regardless of whether the bottom-most level is full, it will require exactly one
more process than traversing to the level above. If one branch is more than 1 level
"higher" than the other, then it will require extra processes.

Alternate (equivalent, but more succinct?) definitions of "balanced" tree?


Is a perfect tree complete?
yes

Is a complete tree balanced?
yes

Is the Man Who Is Tall Happy?
no, because he has a multitude of descendants to look after

What must be true of perfect trees but not others?
All levels, *including the bottom level*, must be full.
================================================


C'EST POSSIBLE?
------------------------------------------------
Pre-Order: EGDKINLOW
In-Order: EKDNIOLWG
    E
     \
      G
     /
    D
   / \
  K   I 
     / \
    N   L
       / \
      O   W
YES
================================================
