#!/bin/bash

source_dir=/c/workspace_01_23_2016/vault_service
dest_dir=/c/workspace_01_23_2016/problemsolving
file_name=README.md
log_fname=$dest_dir/backup_log.log
function copy_data_files() {
    echo "Starting data copy" >> $log_fname
    cp $source_dir/$file_name $dest_dir
    if [ $? == '0' ] 
    then
        echo "Successfully copied file" >> $log_fname
        ls -lrt $dest_dir
        upload_file $file_name
    else
        echo "Failed to copy file" >> $log_fname
    fi
}

function upload_file() {
    echo "Cd $dest_dir" >> $log_fname
    cd $dest_dir
    git pull origin master
    echo "Git pull status - $?" >> $log_fname
    git status
    git add . -f
    echo "Added files - $?" >> $log_fname
    git commit -m "commiting updated data" .
    echo "Commit files - $1 - status $?" >> $log_fname
    git push origin master
    echo "Git push status - $?" >> $log_fname

    rm -rf $log_fname
}


echo "Data backup script" >> $log_fname
copy_data_files
