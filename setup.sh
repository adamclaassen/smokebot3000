#! /bin/bash

exit 0

#install software
sudo apt-git install apache2
sudo apt-get install pi4j
sudo apt-get install git

#add the git repository

git clone https://github.com/adamclaassen/smokebot3000.git
git checkout $1

#symlink the web landing page to apacke's web folder
cp ln -s web/index.html /www/

#disable the serial console on the rpi to make UART available.
sudo chmod 775 scripts/*
sudo scripts/rpi-serial-console.sh disable

sudo reboot
