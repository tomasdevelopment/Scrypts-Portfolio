import openai
import os

# Set up your OpenAI API key
openai.api_key = os.environ["OPENAI_API_KEY"]

print("Welcome to the GPT-3 assistant!")
print("Type 'StopNow' to exit the assistant.")

while True:
    prompt = input("\nWrite your question: ")

    if prompt.strip().lower() == "stopnow":
        print("\nThank you for using the GPT-3 assistant. Goodbye!")
        break

    # Generate text using the GPT-3 language model try different engines
    response = openai.Completion.create(
        engine="text-davinci-002", #text-curie-002 or#text-davinci-002 #text-davinci-002-beta #text-ada-001
        prompt=prompt,
        max_tokens=50,
        n=1,
        stop=None,
        temperature=0.3, ## ##randomness of generatet text, lower values 0.3 higher 0.8 will be more createive
    )

    # Print the generated text
    print(f"\nGPT-3 Assistant: {response.choices[0].text.strip()}")
