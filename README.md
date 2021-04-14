# Git ignore for android projects
To test git ignore for android


 # To update if git ignore not working 
 git rm -r --cached .
 git add .
 git commit -m "fixed untracked files"
 
 # If .idea files not added to git ignore
 git clean -f -d .idea
 git add .
 git commit -m "fixed untracked files"
 

