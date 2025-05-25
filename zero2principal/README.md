1. running LLM with `LM Studio`, with base model `NousResearch/Hermes-2-Pro-Llama-3-8B-GGUF`
2. running LLM with `Docker Ollama`
```shell
docker run -d -v ollama:/root/.ollama -p 1234:11434 --name ollama ollama/ollama
docker exec -it ollama ollama run rl/hermes-2-pro-llama-3-8b-q6_k
```