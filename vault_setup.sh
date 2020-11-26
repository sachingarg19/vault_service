#!/bin/bash
setup_vault() {
    echo "Starting local vault server"
    rm -rf nohup.out
    nohup vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000" &
    if [ $? == '0' ]
    then
        echo "Server started successfully - $?"
        vault kv enable-versioning secret/
    else 
        echo "Trouble to start server -$?"
    fi
}

write_secrets() {
    echo "Started writing secrets"
    vault kv put secret/costipro/costipro-db costipro.username=demouser costipro.password=demopassword
    if [ $? == '0' ] 
    then
        echo "Successfully wrote the secrets - $?"
    else
        echo "Trouble to write secrets - $?"
    fi
}

read_secrets() {
    echo "Started reading secrets"
    vault kv get secret/costipro/costipro-db
    if [ $? == '0' ]
    then
        echo "Successfully read the secrets - $?"
    else
        echo "Trouble to read secrets -$?"
    fi
}

echo "##Starting vault setup"
export VAULT_ADDR="http://127.0.0.1:8200"
export VAULT_TOKEN="00000000-0000-0000-0000-000000000000"
echo "Vault address - $VAULT_ADDR"
echo "Vault token - $VAULT_TOKEN"
setup_vault
write_secrets
read_secrets
