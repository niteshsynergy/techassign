import time

def generate_primes(n):
    is_prime = [True] * (n + 1)
    is_prime[0:2] = [False, False]

    for i in range(2, int(n**0.5) + 1):
        if is_prime[i]:
            for j in range(i * i, n + 1, i):
                is_prime[j] = False

    return [i for i, val in enumerate(is_prime) if val]

# Main Execution
if __name__ == "__main__":
    n = 100000
    start = time.time()
    primes = generate_primes(n)
    end = time.time()

    print(f"Total Primes up to {n}: {len(primes)}")
    print(f"First 10 primes: {primes[:10]}")
    print(f"Execution Time: {round((end - start)*1000, 2)} ms")
