#!/bin/sh
datebeg=$1
dateend=$2
t_sql="ALTER TABLE networkData ADD"
#read datebeg
#read dateend
beg_s=`date -d ${datebeg} +%s`
end_s=`date -d ${dateend} +%s`
echo $beg_s
echo $end_s
while [ "$beg_s" -le "$end_s" ]
    do
        _year=`date -d @$beg_s +%Y`
        _month=`date -d @$beg_s +%m`
        _day=`date -d @$beg_s +%d`
        t_sql=${t_sql}" PARTITION (year="${_year}",month="${_month}",day="${_day}")"
        beg_s=$((beg_s+86400))
    done
echo $t_sql
