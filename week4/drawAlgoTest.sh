#!/usr/bin/bash

declare totalCount=0
declare totalWinCount=0

start_draw() {
    declare counter=0
    declare winCount=0
    for i in {1..10000}; do
        counter=$((counter + 1))
        totalCount=$((totalCount + 1))
        declare result=($(curl localhost:8080/user/draw\?userId=1))
        echo $counter
        echo $result
        if [[ $result == *"商品"* ]]; then
            winCount=$((winCount + 1))
            totalWinCount=$((totalWinCount + 1))
        fi
        echo -e "\n"
    done
    echo -e $counter >>testDrawResult.txt
    echo -e $winCount >>testDrawResult.txt
}

main() {
    echo "============================="
    declare testNum=10
    for ((x = 1; x <= $testNum; x++)); do
        echo "=====START "$x" TEST=====" >>testDrawResult.txt
        start_draw
        echo -e "=======END "$x" TEST=====\n" >>testDrawResult.txt
    done

    echo -e "Total Count: "$totalCount >>testDrawResult.txt
    echo -e "Total Win Count: "$totalWinCount"\n" >>testDrawResult.txt
}

main
