#cd /storage/emulated/0/ACode/Projects/Coding/Java/pack

if [ ! -d ".git" ]; then
	echo "Error: This is not git repository."
	exit 1
fi

read -p "Enter the message commit: " commit_message
git add .
git commit -m "$commit_message"
echo "Successfuly commit with message: $commit_message"
read -p "Enter the branch name for push (default: master): " branch_name
branch_name=${branch_name:-master}
git push origin "$branch_name"

if [ $? -eq 0 ]; then
	echo "Successfuly push to branch: $branch_name"
else
	echo "Error: Push failed."
fi