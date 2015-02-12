#! /bin/bash
echo "Don't run this, it does not work yet"
exit 0
ROBOTNAME=$1
USERNAME = $(whoami)

sudo apt-get update
sudo apt-get install apache2

sudo cat $ROBOTNAME > /etc/hostname
sudo ln -s /home/$USERNAME/smokebot3000/web/$ROBOTNAME.html /var/www/index.html


sudo reboot
