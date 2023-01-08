--Prende una lista e un elemento da cercare e restituisce la tupla
--(lista ordinata, elemento da cercare, posizione dell'elemento nella lista ORDINATA)
binarySearch :: Ord a => ([a] -> [a]) -> a -> [a] -> ([a], a, Int)
binarySearch sortingAlg x xs = (sorted, x, search sorted 0 (length xs - 1))
  where sorted = sortingAlg xs --lista input ordinata
        search l low high --funzione di ricerca
          | low > high = -1  --elemento non trovato
          | guess == x = mid --elemento trovato
          | guess < x  = search l (mid + 1) high
          | otherwise  = search l low (mid - 1)
                  where mid = low + (high - low) `div` 2 --indice medio
                        guess = l!!mid --elemento all'indice medio

--ordina una lista di elementi (algoritmo bubble sort)
bubbleSort :: Ord a => [a] -> [a]
bubbleSort xs = go xs 0
  where go xs i = if i == length xs then xs
                  else go (sort xs) (i + 1)
--singola iterazione del bubbleSort     
sort :: Ord a => [a] -> [a]
sort [] = []
sort [x] = [x]
sort (x:y:xs) = if x > y then y:sort(x:xs)
                else x:sort(y:xs)

--funzione per l'utilizzo della definizione di liste come in matematica
--e la wildcard _
delete :: Int -> [(Int,Char)] -> [Int]
delete i xs = [ i' | (i',_) <- xs, i' /= i]

main = do
  --semplice prova di delete e di una lambda function
  print (map (\x -> x^x) (delete 2 [(1,'a'), (2,'b'), (3,'b')]))

  --utilizzo binarySearch e bubbleSort con interazione con l'utente
  putStrLn "Inserisci una lista di caratteri"
  input1 <- getLine
  let l = (read input1 :: [Char])
  putStrLn "Inserisci un carattere da cercare"
  input2 <- getLine
  let c = (read input2 :: Char)
  putStrLn "L'output seguente presenta la lista ordinara, il carattere cercato e la sua posizione nella lista ordinata:"
  print(binarySearch bubbleSort c l)