#! /bin/bash

exit 0

#install software
sudo apt-git install apache2
sudo apt-get install pi4j
sudo apt-get install git
sudo apt-get install wicd
#add the git repository

git clone https://github.com/adamclaassen/smokebot3000.git
git checkout $1

#symlink the web landing page to apacke's web folder
cp index.html bin/
sudo ln -s /home/$(id)/smokebot3000/bin/index.html /var/www/
sudo chmod -R 777 bin/

#disable the serial console on the rpi to make UART available.
sudo chmod 775 scripts/*
sudo scripts/rpi-serial-console.sh disable
sudo cat $1 > "etc/hostname"

sudo reboot
