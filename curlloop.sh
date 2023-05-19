while true; do sleep 0.5; echo "`date` - $(curl -s $1 | jq . -c)"; done
