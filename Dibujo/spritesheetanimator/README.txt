#================================================================================
# Quick Notes:
#================================================================================
Once you're done reading instructions and whatever there are examples here that
may help you understand how to use the program more. What you'll want to do
is load up the 'Chelsea.png' then load the 'Chelsea.iptz' image data.

If you run into any errors, bugs, or have a suggestion, please let me know.
PM me at http://chaos-project.com : username is game_guy
Email me at gameguysprojects@hotmail.com or blocker222@gmail.com
Send me a youtube PM at http://youtube.com/gameguysprojects

#================================================================================
# Intro:
#================================================================================
Sprite Sheet Animator is a simple easy to use program. Its uses are to take for
say a character set or an animated battler and seperate each column and turn it 
into an animated image file to show off how it looks.

#================================================================================
# Instructions:
#================================================================================
I will have a real help manual eventually but for now you have this.

Click load image, then load the image you want to split up. 
Specify the number of columns and rows.
Choose the export option.
Individual
-Exports each column into its own animated file.
Merged
-Exports each column into one animated file.
Then click Export and save.

Though if you're dealing with images that have blank frames at the end
of each column, you may want to read Image Data.

#================================================================================
# Image Data:
#================================================================================
Image Data is what it sounds like. Its data thats used to keep track
of the image and uses it so it knows how to seperate the image. In
an animated battler for example probably isn't going to have each
frame in each column filled with a sprite so if you export the image
with no editing at all it'll display the gif with blank frames which
looks horrible may I point out.

So if you have a graphic that doesn't have each frame filled you'll
want to click Edit Data to change this. Then you go through each column
and specify how many visible frames there are for each column. Then the
program exports the files just fine.

You can also save and load image data that way you don't have to go through
setting it up each time. Note that every time you load a new image or change
the number of rows or columns, it resets the image data and you have to go
and edit it again. Image data is saved as a .iptz extension.

When saving image data it also saves the rows and columns. So when 
you load up the image data it'll automatically change everything for
you so you don't need to go through all the work again to set up
columns and rows and visible frames.

#================================================================================
# Credts:
#================================================================================
Ronnie Mooney (game_guy) ~ Creator of the program.
Branden ~ Opinions, looking up info on internet when I wasn't able to.
Dwellercoc ~ Requesting some new options compared to my old RMXP Sprite Animtor.

Special Thanks to creators of NGif