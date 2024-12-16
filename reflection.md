Our overall approach to tacking the project was to develop a basic storyline, develop the necessary classes to implement the storyline, and then flesh out the various do, while loops within the GameLoop file to connect the classes to the storyline. Ash, an astronomy major, wanted to build a game implementing some of the cool things she learned taking a planetary science class this semester in a game. Lucy was excited to work on any game topic, so we worked together to implement our game vision, which evolved as we collaborated. 

 A new thing we learned was how to incorporate ASCII text into our game. Ash took the lead on this, searching around for how to write methods that would correctly print out the images from text files stored in a folder, and then generated text files for each image we wanted to show using an online ascii art generator (here: https://www.asciiart.eu/image-to-ascii, image credit: NASA, ESA). This turned out to be a big hit — everyone we showed the game to was very impressed, and it made people more immersed and invested in the game. We also had to learn how to change text colors - Lucy took the lead on this. We wanted to add yet aother interesting visual feature to make the simple text-based interface more engaging, and Lucy figured out how to make some of the alien speech/spaceship warning print in different colors. 

 Regarding different code implementation, we are not sure if we would have done much differently. For one, the dialoge for the queen alien is implented in the User class rather than Alien, which does not take away from the game performance, but would make more sense to migrate over from a code point of view. In addition, we wanted to include more time delay between text printing. We implemented a delay in the intro/end sequences, but doing so added lots of clutter to the code, and we tried to find an alternative way to delay code, but could not. Finally, we would have liked to implement more instances of method overloading or some of the newer concepts in class. We implement the overloading method for initializing Being instances without names (bacteria), but nowhere else. Although there were not a lot of times where implementing the method would make sense, it would have led to a more advanced codebase. 

 If we had unlimited time on the project, we would have implemented more options/Easter eggs in the game. For example, in the game intro sequence, there are a few hidden clues as to where to look to complete the game and the overall premisce of the game, such as the book on Jupiter's moon's habitability, the picture of the familiar child (you!). Later in the game, some of the non-boss aliens, when spoken to, will hint at where to look for the end game sequence (Moons of Jupiter). While these clues are helpful, a lot of players missed them, which made them not sure how to proceed. Also, we would have liked to incorporate more events that occur as the game progresses. One of the initial visions for the game was to have a clock as time passes (player travels), and after a certain amount of time, other planets would be destroyed by the aliens. Implementing this would not have been extremly difficult, but we did not have enough time to do so. Finally, a lot of players we tested the game on were not very familiar with the Solar System, so some more background information, such as listing all the planet names / distances via a more in depth map than the one projected on the screen in the introduction would have helpful. 

 Some of the best pieces of feedback we got while working on this project were on small things, such as directions or places that we hadn't considered including in our game. When we played to test things, we always knew exactly what to type in to get the right outcomes and move the game along. When other people played, they often did things that we saw as counter-intuitive, but that they saw as obvious or just as valid as our "right" moves. For example, one of Lucy's friends was confused as to why one the most prominent celestial bodies — the Sun — wasn't an object, according to our game. Lucy went in shortly after and added the Sun, expanding the scope of our project. By taking in this feedback, we were able to grow the game, making it more complete and more fun for people other than us two. 

 If we could go back in time and give our past selves advice about this project, we might say to constrain our goals a bit. Early in the project, we had a lot of superfluous attributes and methods that didn't add anything to the game — such as allowing the user to dig on planets, or having rations on the spaceship. These attributes may have worked in a different game, but they were completely irrelevant to our final product. While it wasn't a giant waste of time — many of these aspects were just a few lines of code — it may have kept us from expanding our project in other, better ways. It would've been best to focus first on the overarching structure of the game and the details necessary to build it, before worrying about tiny details that may or may not make it into the final product. 

 Our team dynamic made this project easier for the both of us. At this point in the semester, we were well-equipped to work with each other, as we had been doing homework assignments together since September. We understood how the other person worked, what their strengths were, and how to effectively communicate. This made the actual workflow incredibly smooth. We would each work on parts of the project separately, before coming back together during class to talk about the best next steps. Ash took the lead on a lot of the coding parts of the project, establishing the do/while structure and some important methods (like the ASCII art and the input scanning method). Lucy took the lead on a lot of the documentation/details of the project, such as JavaDoc comments and text colors. However, there was definetely lots of overlap: no one did any part of the project entirely alone, or without support from the other. 