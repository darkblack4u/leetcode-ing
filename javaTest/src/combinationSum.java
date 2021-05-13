public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    List<Integer> combination = new ArrayList<Integer>();
    backTrace(ret, combination, candidates, target, 0);
    return ret;
}
public void backTrace(List<List<Integer>> ret, List<Integer> combination, int[] candidates, int target, int position){
    if(position == candidates.length){
        return;
    }
    if(target == 0){
        ret.add(new ArrayList<Integer>(combination));
        return;
    }
    backTrace(ret, combination, candidates, target, position + 1);
    if(target - candidates[position] >= 0){
        combination.add(candidates[position]);
        backTrace(ret, combination, candidates, target - candidates[position], position);
        combination.remove(combination.size() - 1);
    }
}
}