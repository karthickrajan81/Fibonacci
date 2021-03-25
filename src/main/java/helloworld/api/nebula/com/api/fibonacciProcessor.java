package helloworld.api.nebula.com.api;

import java.util.Collection;
import java.util.HashMap;

public class fibonacciProcessor {
    private HashMap<Integer,Long> _cache = new HashMap<Integer,Long>();
	private int _inputNumber;
    public fibonacciProcessor(int inputNumber)
    {
		_inputNumber= inputNumber;
		processFibonacciSeries(inputNumber);
    }

    private Long processFibonacciSeries(int inputNumber)
	{
		if(inputNumber > 1)
		{
			var n1= inputNumber -1;
			if(!_cache.containsKey(n1))
			{
				_cache.put(n1, processFibonacciSeries(n1));
			}			
			var n2= inputNumber -2;
			if(!_cache.containsKey(n2))
			{
				_cache.put(n2, processFibonacciSeries(n2));
			}
			_cache.put(inputNumber,_cache.get(n1)+_cache.get(n2));          
		}
		else
		{
			if(!_cache.containsKey(inputNumber))
			{
				_cache.put(inputNumber,(long)inputNumber);				

			}		
		}
		return _cache.get(inputNumber);
	}

	public Collection<Long> GetFibonacciSeries()
	{
		return _cache.values();
	}

	public Long GetSumOfFibonacciSeries()
	{
		return _cache.get(_inputNumber);
	}

}
