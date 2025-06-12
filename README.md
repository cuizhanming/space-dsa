## `DSA` section guide
- [DSA in Comics](/pdfs/DSAInComics.pdf)
- [Zero to Principal](https://www.skool.com/zero-to-principal-engineer/classroom/3d2e5477?md=c9a84042be914f868275595db7308519)
- [The SWE (Software Engineer) Interview Prep RoadMap](https://javarevisited.substack.com/p/the-swe-software-engineer-interview)

## Run `engineering` application guide:
1. running LLM with `LM Studio`, with base model `NousResearch/Hermes-2-Pro-Llama-3-8B-GGUF`
2. running LLM with `Docker Ollama`
```shell
docker run -d -v ollama:/root/.ollama -p 1234:11434 --name ollama ollama/ollama
docker exec -it ollama ollama run rl/hermes-2-pro-llama-3-8b-q6_k
```